package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.atomic.GetIncidentByAttackerIdCommand;
import com.ucab.cmcapp.logic.commands.Incident.atomic.GetIncidentByVictimIdCommand;
import com.ucab.cmcapp.logic.commands.Incident.composite.CreateIncidentCommand;
import com.ucab.cmcapp.logic.commands.Incident.composite.GetAllIncidentCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.GetVictimByUserIdCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.CreateVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.GetAllVictimCommand;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import com.ucab.cmcapp.logic.mappers.IncidentMapper;
import com.ucab.cmcapp.logic.mappers.VictimMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/incident")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IncidentService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(IncidentService.class);

    @GET
    @Path("/all")
    public Response getAllIncidents() {
        List<IncidentDto> responseDTO = null;
        GetAllIncidentCommand command = null;

        try {
            command = CommandFactory.createGetAllIncidentCommand();
            command.execute();
            responseDTO = IncidentMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty())
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] Currently there are no victim-attacker relationships in database")).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllIncidents: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully listed all victim-attacker relationships")).build();
    }

    @GET
    @Path("victimRegistry/{victim_id}")
    public Response getIncidentByVictimId(@PathParam("victim_id") String victimId) {
        Incident entity;
        IncidentDto responseDTO = null;
        GetIncidentByVictimIdCommand command = null;

        try {
            entity = IncidentMapper.mapDtoToEntityVictimId(victimId);
            command = CommandFactory.createGetIncidentByVictimIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = IncidentMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No attacker-victim relationship found for victim registry id: " + victimId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getIncidentByVictimId: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found attacker-victim relationship with victim registry id: " + victimId)).build();
    }

    @GET
    @Path("attackerRegistry/{attacker_id}")
    public Response getIncidentByAttackerId(@PathParam("attacker_id") String attackerId) {
        Incident entity;
        IncidentDto responseDTO = null;
        GetIncidentByAttackerIdCommand command = null;

        try {
            entity = IncidentMapper.mapDtoToEntityAttackerId(attackerId);
            command = CommandFactory.createGetIncidentByAttackerIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = IncidentMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No attacker-victim relationship found for attacker registry id: " + attackerId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getIncidentByVictimId: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found attacker-victim relationship with attacker registry id: " + attackerId)).build();
    }

    @POST
    public Response addIncident(IncidentDto incidentDto) {
        Incident entity;
        IncidentDto responseDTO = null;
        CreateIncidentCommand command = null;

        try {
            entity = IncidentMapper.mapDtoToEntity(incidentDto);
            command = CommandFactory.createCreateIncidentCommand(entity);
            command.execute();
            responseDTO = IncidentMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method addIncident, relationship attacker-victim could not be added: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] relationship attacker-victim created successfully")).build();
    }

}
