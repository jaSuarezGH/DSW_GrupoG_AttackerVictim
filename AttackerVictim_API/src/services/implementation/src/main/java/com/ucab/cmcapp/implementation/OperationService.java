package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.composite.GetIncidentCommand;
import com.ucab.cmcapp.logic.commands.operation.atomic.GetAttackerLastPositionByIncidentIdCommand;
import com.ucab.cmcapp.logic.commands.operation.atomic.GetLastPositionsByIncidentIdCommand;
import com.ucab.cmcapp.logic.commands.safeZone.atomic.GetAllSafeZoneByUserIdCommand;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import com.ucab.cmcapp.logic.dtos.SafeZoneDto;
import com.ucab.cmcapp.logic.mappers.HistoryMapper;
import com.ucab.cmcapp.logic.mappers.IncidentMapper;
import com.ucab.cmcapp.logic.mappers.SafeZoneMapper;
import com.ucab.cmcapp.logic.utilities.DistanceManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/operation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperationService extends BaseService {

    @GET
    @Path("separation-distance/{incident_id}")
    public Response getSeparationDistanceByIncidentId(@PathParam("incident_id") long incidentId) {
        Incident entity;
        List<HistoryDto> responseDTO = null;
        GetLastPositionsByIncidentIdCommand command = null;
        double separationDistance;

        try {
            entity = IncidentMapper.mapDtoToEntity(incidentId);
            command = CommandFactory.createGetLastPositionsByIncidentIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null) {
                responseDTO = HistoryMapper.mapEntityListToDtoList(command.getReturnParam());
                separationDistance = new DistanceManager().calculateSeparationDistance(responseDTO.get(0), responseDTO.get(1));
            } else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[GENERAL EXCEPTION] Could not calculate the separation distance with incident id: " + incidentId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getSeparationDistanceByIncidentId: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(separationDistance, "[OK NORMAL RESPONSE] Successfully calculated separation distance in meters with incident id: " + incidentId)).build();
    }

    @GET
    @Path("attacker-in-safe-zone/{incident_id}")
    public Response getVerifyAttackerInSafeZone(@PathParam("incident_id") long incidentId) {
        Incident incidentEntity;
        IncidentDto incidentDto = null;
        GetIncidentCommand incidentCommand = null;

        //+++++++++++++++

        SafeZone safeZoneEntity;
        List<SafeZoneDto> safeZoneDto = null;
        GetAllSafeZoneByUserIdCommand safeZoneCommand = null;

        //+++++++++++++++

        //incidentEntity
        HistoryDto historyDto = null;
        GetAttackerLastPositionByIncidentIdCommand attackerPositionCommand = null;

        //+++++++++++++++

        List<CustomResponse> tempOut;

        try {
            incidentEntity = IncidentMapper.mapDtoToEntity(incidentId);
            incidentCommand = CommandFactory.createGetIncidentCommand(incidentEntity);
            incidentCommand.execute();

            if (incidentCommand.getReturnParam() != null)
                incidentDto = IncidentMapper.mapEntityToDto(incidentCommand.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No victim-attacker relationships found for id: " + incidentId)).build();

            //--------------------------------------

            safeZoneEntity = SafeZoneMapper.mapDtoToEntityUserId(incidentDto.get_victim().get_user().getId()); // Aqui obtengo del incidente la victima y luego su id de user
            safeZoneCommand = CommandFactory.createGetAllSafeZoneByUserIdCommand(safeZoneEntity);
            safeZoneCommand.execute();

            if (safeZoneCommand.getReturnParam() != null)
                safeZoneDto = SafeZoneMapper.mapEntityListToDtoList(safeZoneCommand.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No safe zones found for user_id: " + incidentDto.get_victim().get_user().getId())).build();

            //--------------------------------------

            attackerPositionCommand = CommandFactory.createGetAttackerLastPositionsByIncidentIdCommand(incidentEntity);
            attackerPositionCommand.execute();

            if (attackerPositionCommand.getReturnParam() != null) {
                historyDto = HistoryMapper.mapEntityToDto(attackerPositionCommand.getReturnParam());
                //separationDistance = new DistanceManager().calculateSeparationDistance(responseDTO.get(0), responseDTO.get(1));
            } else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[GENERAL EXCEPTION] Could not calculate the separation distance with incident id: " + incidentId)).build();


            //--------------------------------------

            tempOut = new ArrayList<>();

            tempOut.add(new CustomResponse<>(incidentDto, "INCIDENTE"));
            tempOut.add(new CustomResponse<>(safeZoneDto, "VICTIMS SAFE ZONES"));
            tempOut.add(new CustomResponse<>(historyDto, "ATTACKER LAST POSITION"));

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getIncidentById: " + e.getMessage())).build();
        } finally {
            if (incidentCommand != null)
                incidentCommand.closeHandlerSession();
            if (safeZoneCommand != null)
                safeZoneCommand.closeHandlerSession();
            if (attackerPositionCommand != null)
                attackerPositionCommand.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(tempOut, "[OK NORMAL RESPONSE] Successfully found victim-attacker relationships with id: " + incidentId)).build();
    }

}
