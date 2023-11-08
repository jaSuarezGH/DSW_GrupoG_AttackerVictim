package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByUsernameCommand;
import com.ucab.cmcapp.logic.commands.user.composite.DeleteUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.UpdateUserCommand;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(UserService.class);

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") long userId) {
        User entity;
        UserDto responseDTO = null;
        GetUserCommand command = null;

        try {
            entity = UserMapper.mapDtoToEntity(userId);
            command = CommandFactory.createGetUserCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UserMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No user found for id " + userId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error getUser with id " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User for id " + userId + " found correctly")).build();
    }


    @GET
    @Path("email/{email}")
    public Response getUserByEmail(@PathParam("email") String userEmail) {
        User entity;
        UserDto responseDTO = null;
        GetUserByEmailCommand command = null;

        try {
            entity = UserMapper.mapDtoToEntityEmail(userEmail);
            command = CommandFactory.createGetUserByEmailCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UserMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No user found for email " + userEmail)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error getUser with email: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User for email " + userEmail + " found correctly")).build();
    }

    @GET
    @Path("username/{username}")
    public Response getUserByUsername(@PathParam("username") String username) {
        User entity;
        UserDto responseDTO = null;
        GetUserByUsernameCommand command = null;

        try {
            entity = UserMapper.mapDtoToEntityUsername(username);
            command = CommandFactory.createGetUserByUsernameCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UserMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No user found for username " + username)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error getUser with username: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User for username " + username + " found correctly")).build();
    }

    @POST
    public Response addUser(UserDto userDto) {
        User entity;
        UserDto responseDTO = null;
        CreateUserCommand command = null;

        try {
            entity = UserMapper.mapDtoToEntity(userDto);
            command = CommandFactory.createCreateUserCommand(entity);
            command.execute();
            responseDTO = UserMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User created correctly")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") long userId) {
        User entity;
        UserDto responseDTO = null;
        DeleteUserCommand command = null;

        try {
            entity = UserMapper.mapDtoToEntity(userId);
            command = CommandFactory.createDeleteUserCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UserMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("Could not delete user")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User eliminated correctly")).build();
    }

    @PUT
    public Response updateUser(UserDto userDto) {
        User entity;
        UserDto responseDTO = null;
        UpdateUserCommand command = null;
        try {
            entity = UserMapper.mapDtoToEntity(userDto);
            command = CommandFactory.createUpdateUserCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = UserMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("Could not edit user with id: " + userDto.getId())).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Exception error in updateUser: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User with id " + userDto.getId() + " modified correctly")).build();
    }
}
