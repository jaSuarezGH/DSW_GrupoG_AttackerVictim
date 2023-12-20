package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.operation.atomic.GetLastPositionsByIncidentIdCommand;
import com.ucab.cmcapp.logic.commands.safeZone.atomic.GetAllSafeZoneByUserIdCommand;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.SafeZoneDto;
import com.ucab.cmcapp.logic.mappers.HistoryMapper;
import com.ucab.cmcapp.logic.mappers.IncidentMapper;
import com.ucab.cmcapp.logic.mappers.SafeZoneMapper;
import com.ucab.cmcapp.logic.utilities.DistanceManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/operation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperationService extends BaseService {

    @GET
    @Path("/{incident_id}")
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

    /*@GET
    @Path("/{user_id}")
    public Response getVerifyAttackerInSafeZone(@PathParam("user_id") long userId) {
        SafeZone entity;
        List<SafeZoneDto> responseZonesDTO = null;
        GetAllSafeZoneByUserIdCommand command = null;

        try {
            entity = SafeZoneMapper.mapDtoToEntityUserId(userId);
            command = CommandFactory.createGetAllSafeZoneByUserIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseZonesDTO = SafeZoneMapper.mapEntityListToDtoList(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No safe zones found for user_id: " + userId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllSafeZonesByUserId: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseZonesDTO, "[OK NORMAL RESPONSE] Successfully found all histories with user_id: " + userId)).build();
    }*/

}
