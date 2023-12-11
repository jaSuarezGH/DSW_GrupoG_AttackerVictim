package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrator.atomic.GetAdministratorByEmailCommand;
import com.ucab.cmcapp.logic.commands.administrator.atomic.GetAdministratorByUsernameCommand;
import com.ucab.cmcapp.logic.commands.administrator.composite.CreateAdministratorCommand;
import com.ucab.cmcapp.logic.commands.administrator.composite.GetAllAdministratorCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByUsernameCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetAllUserCommand;
import com.ucab.cmcapp.logic.dtos.AdministratorDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.AdministratorMapper;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/administrator")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdministratorService extends BaseService {

    private static Logger _logger = LoggerFactory.getLogger(AdministratorService.class);

    @GET
    @Path("/all")
    public Response getAllAdministrators() {
        List<AdministratorDto> responseDTO = null;
        GetAllAdministratorCommand command = null;

        try {
            command = CommandFactory.createGetAllAdministratorCommand();
            command.execute();
            responseDTO = AdministratorMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty())
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] Currently there are no administrators in database")).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllAdministrators: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully listed all administrators")).build();
    }

    @GET
    @Path("email/{email}")
    public Response getAdministratorByEmail(@PathParam("email") String administratorEmail) {
        Administrator entity;
        AdministratorDto responseDTO = null;
        GetAdministratorByEmailCommand command = null;

        try {
            entity = AdministratorMapper.mapDtoToEntityEmail(administratorEmail);
            command = CommandFactory.createGetAdministratorByEmailCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AdministratorMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No administrators found for email: " + administratorEmail)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAdministratorByEmail: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found administrator with email: " + administratorEmail)).build();
    }

    @GET
    @Path("username/{username}")
    public Response getAdministratorByUsername(@PathParam("username") String username) {
        Administrator entity;
        AdministratorDto responseDTO = null;
        GetAdministratorByUsernameCommand command = null;

        try {
            entity = AdministratorMapper.mapDtoToEntityUsername(username);
            command = CommandFactory.createGetAdministratorByUsernameCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AdministratorMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No administrator found for username: " + username)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAdministratorByUsername: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found administrator with username: " + username)).build();
    }

    @POST
    public Response addAdministrator(AdministratorDto administratorDto) {
        Administrator entity;
        AdministratorDto responseDTO = null;
        CreateAdministratorCommand command = null;

        try {
            entity = AdministratorMapper.mapDtoToEntity(administratorDto);
            command = CommandFactory.createCreateAdministratorCommand(entity);
            command.execute();
            responseDTO = AdministratorMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method addAdministrator, administrator could not be added: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] administrator created successfully")).build();
    }

}
