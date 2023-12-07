package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.history.atomic.GetAllHistoryByUserIdCommand;
import com.ucab.cmcapp.logic.commands.history.composite.CreateHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.composite.DeleteHistoryCommand;
import com.ucab.cmcapp.logic.commands.safeZone.atomic.GetAllSafeZoneByUserIdCommand;
import com.ucab.cmcapp.logic.commands.safeZone.composite.CreateSafeZoneCommand;
import com.ucab.cmcapp.logic.commands.safeZone.composite.DeleteSafeZoneCommand;
import com.ucab.cmcapp.logic.commands.safeZone.composite.GetAllSafeZoneCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.GetAllVictimCommand;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.SafeZoneDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import com.ucab.cmcapp.logic.mappers.HistoryMapper;
import com.ucab.cmcapp.logic.mappers.SafeZoneMapper;
import com.ucab.cmcapp.logic.mappers.VictimMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/safezone")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SafeZoneService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(SafeZoneService.class);

    @GET
    @Path("/all")
    public Response getAllSafeZones() {
        List<SafeZoneDto> responseDTO = null;
        GetAllSafeZoneCommand command = null;

        try {
            command = CommandFactory.createGetAllSafeZoneCommand();
            command.execute();
            responseDTO = SafeZoneMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty())
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] Currently there are no safe zones in database")).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllSafeZones: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully listed all safe zones")).build();
    }

    @GET
    @Path("/{user_id}")
    public Response getAllSafeZonesByUserId(@PathParam("user_id") String userId) {
        SafeZone entity;
        List<SafeZoneDto> responseDTO = null;
        GetAllSafeZoneByUserIdCommand command = null;

        try {
            entity = SafeZoneMapper.mapDtoToEntityUserId(userId);
            command = CommandFactory.createGetAllSafeZoneByUserIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = SafeZoneMapper.mapEntityListToDtoList(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No safe zones found for user_id: " + userId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllSafeZonesByUserId: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found all histories with user_id: " + userId)).build();
    }

    @POST
    public Response addSafeZone(SafeZoneDto safeZoneDto) {
        SafeZone entity;
        SafeZoneDto responseDTO = null;
        CreateSafeZoneCommand command = null;

        try {
            entity = SafeZoneMapper.mapDtoToEntity(safeZoneDto);
            command = CommandFactory.createCreateSafeZoneCommand(entity);
            command.execute();
            responseDTO = SafeZoneMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method addSafeZone, safe zone could not be added: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] safe zone created successfully")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSafeZone(@PathParam("id") long safeZoneId) {
        SafeZone entity;
        SafeZoneDto responseDTO;
        DeleteSafeZoneCommand command = null;

        try {
            entity = SafeZoneMapper.mapDtoToEntity(safeZoneId);
            command = CommandFactory.createDeleteSafeZoneCommand(entity);
            command.execute();
            entity = command.getReturnParam();
            responseDTO = SafeZoneMapper.mapEntityToDto(entity);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method deleteSafeZone, safe zone could not be deleted: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully deleted safe zone registry with id: " + safeZoneId)).build();
    }

}
