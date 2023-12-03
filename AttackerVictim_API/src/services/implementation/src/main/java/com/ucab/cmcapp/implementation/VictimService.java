package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByMacAddressCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.DeleteUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetAllUserCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.GetVictimByUserIdCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.CreateVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.DeleteVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.GetAllVictimCommand;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import com.ucab.cmcapp.logic.mappers.VictimMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/victim")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VictimService extends BaseService {

    private static Logger _logger = LoggerFactory.getLogger(VictimService.class);

    @GET
    @Path("/all")
    public Response getAllVictims() {
        List<VictimDto> responseDTO = null;
        GetAllVictimCommand command = null;

        try {
            command = CommandFactory.createGetAllVictimCommand();
            command.execute();
            responseDTO = VictimMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty())
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] Currently there are no victims in database")).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllVictims: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully listed all victims")).build();
    }

    @GET
    @Path("/{user_id}")
    public Response getVictimByUserId(@PathParam("user_id") String userId) {
        Victim entity;
        VictimDto responseDTO = null;
        GetVictimByUserIdCommand command = null;

        try {
            entity = VictimMapper.mapDtoToEntityUserId(userId);
            command = CommandFactory.createGetVictimByUserIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = VictimMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No victim found for user_id: " + userId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getVictimByUserId: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found victim with user_id: " + userId)).build();
    }

    @POST
    public Response addVictim(VictimDto victimDto) {
        Victim entity;
        VictimDto responseDTO = null;
        CreateVictimCommand command = null;

        try {
            entity = VictimMapper.mapDtoToEntity(victimDto);
            command = CommandFactory.createCreateVictimCommand(entity);
            command.execute();
            responseDTO = VictimMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method addVictim, user could not be added: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] victim created successfully")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteVictim(@PathParam("id") long victimId) {
        Victim entity;
        VictimDto responseDTO;
        DeleteVictimCommand command = null;

        try {
            entity = VictimMapper.mapDtoToEntity(victimId);
            command = CommandFactory.createDeleteVictimCommand(entity);
            command.execute();
            entity = command.getReturnParam();
            responseDTO = VictimMapper.mapEntityToDto(entity);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method deleteVictim, user could not be deleted: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully deleted victim with id: " + victimId)).build();
    }

}
