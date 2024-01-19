package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByMacAddressCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByPersonalIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByUsernameCommand;
import com.ucab.cmcapp.logic.commands.user.composite.*;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.UserLoginDto;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import com.ucab.cmcapp.logic.utilities.LdapUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(UserService.class);

    /**
     * Este endpoint realiza la autenticacion de usuarios usando LDAP
     *
     * @param userLoginDto estructura de UserLoginDto
     * @return CustomResponse con booleano resultado de autenticacion o excepcion
     */
    @POST
    @Path("/auth")
    public Response authUser(UserLoginDto userLoginDto) {
        try {
            if (LdapUserManager.authUser(userLoginDto.get_username(), userLoginDto.get_password())) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>(true, "[OK POSITIVE RESPONSE] user authenticated successfully")).build();
            } else {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>(false, "[OK NEGATIVE RESPONSE] user could not be authenticated")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method authUser, user could not be authenticated: " + e.getMessage())).build();
        }
    }

    /**
     * Este metodo consulta todos los usuarios
     *
     * @return CustomResponse con lista de UserDto o null o excepcion
     */
    @GET
    @Path("/all")
    public Response getAllUsers() {
        List<UserDto> responseDTO = null;
        GetAllUserCommand command = null;

        try {
            command = CommandFactory.createGetAllUserCommand();
            command.execute();
            responseDTO = UserMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty())
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] Currently there are no users in database")).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllUsers: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully listed all users")).build();
    }

    /**
     * Este metodo consulta un usuario por id
     *
     * @param userId id de usuario a consultar
     * @return CustomResponse con UserDto o null o excepcion
     */
    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") long userId) {
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
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No user found for id: " + userId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getUserById: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found user with id: " + userId)).build();
    }

    /**
     * Este endpoint consulta un usuario por email
     *
     * @param userEmail email de usuario a consultar
     * @return CustomResponse con UserDto o null o excepcion
     */
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
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No user found for email: " + userEmail)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getUserByEmail: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found user with email: " + userEmail)).build();
    }

    /**
     * Este endpoint consulta un usuario por username
     *
     * @param username username de usuario a consultar
     * @return CustomResponse con UserDto o null o excepcion
     */
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
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No user found for username: " + username)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getUserByUsername: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found user with username: " + username)).build();
    }

    /**
     * Este endpoint consulta un usuario por cedula
     *
     * @param personal_id cedula de usuario a consultar
     * @return CustomResponse con UserDto o null o excepcion
     */
    @GET
    @Path("personal_id/{personal_id}")
    public Response getUserByPersonalId(@PathParam("personal_id") String personal_id) {
        User entity;
        UserDto responseDTO = null;
        GetUserByPersonalIdCommand command = null;

        try {
            entity = UserMapper.mapDtoToEntityPersonalId(personal_id);
            command = CommandFactory.createGetUserByPersonalIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UserMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No user found for personal_id: " + personal_id)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getUserByPersonalId: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found user with personal_id: " + personal_id)).build();
    }

    /**
     * Este endpoint consulta un usuario por direccion MAC
     *
     * @param mac_address direccion MAC del usuario a consultar
     * @return CustomResponse con UserDto o null o excepcion
     */
    @GET
    @Path("mac/{mac_adress}")
    public Response getUserByMacAddress(@PathParam("mac_adress") String mac_address) {
        User entity;
        UserDto responseDTO = null;
        GetUserByMacAddressCommand command = null;

        try {
            entity = UserMapper.mapDtoToEntityMacAddress(mac_address);
            command = CommandFactory.createGetUserByMacAddressCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UserMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No user found for mac_address: " + mac_address)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getUserByMacAddress: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found user with mac_address: " + mac_address)).build();
    }

    /**
     * Este endpoint agrega un usuario
     *
     * @param userDto estructura de usuario a agregar
     * @return CustomResponse con UserDto agregado o excepcion
     */
    @POST
    public Response addUser(UserDto userDto) {
        User entity;
        UserDto responseDTO = null;
        CreateUserCommand command = null;
        LdapUserManager ldap = new LdapUserManager();

        try {
            entity = UserMapper.mapDtoToEntity(userDto);
            command = CommandFactory.createCreateUserCommand(entity);
            command.execute();
            responseDTO = UserMapper.mapEntityToDto(command.getReturnParam());

            // Agregar usuario en LDAP
            if (!LdapUserManager.authUser(userDto.get_username(), userDto.get_password()))
                ldap.addUser(userDto.get_username(), userDto.get_password());

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method addUser, user could not be added: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] user created successfully")).build();
    }

    /**
     * Este endpoint elimina un usuario por id
     *
     * @param userId id de usuario a eliminar
     * @return CustomResponse con UserDto eliminado o excepcion
     */
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") long userId) {
        User entity;
        UserDto responseDTO = null;
        UserDto ldapDto = null;
        DeleteUserCommand deleteCommand = null;
        GetUserCommand getCommand = null;
        LdapUserManager ldap = new LdapUserManager();

        try {
            entity = UserMapper.mapDtoToEntity(userId);
            getCommand = CommandFactory.createGetUserCommand(entity);
            getCommand.execute();

            if (getCommand.getReturnParam() != null)
                ldapDto = UserMapper.mapEntityToDto(getCommand.getReturnParam());
            else
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method deleteUser, user with id " + userId + " could not be found")).build();

            entity = UserMapper.mapDtoToEntity(userId);
            deleteCommand = CommandFactory.createDeleteUserCommand(entity);
            deleteCommand.execute();
            responseDTO = UserMapper.mapEntityToDto(deleteCommand.getReturnParam());

            // Eliminar usuario de LDAP
            if (LdapUserManager.authUser(ldapDto.get_username(), ldapDto.get_password()))
                ldap.deleteUser(ldapDto.get_username());

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method deleteUser, user could not be deleted: " + e.getMessage())).build();
        } finally {
            if (deleteCommand != null)
                deleteCommand.closeHandlerSession();
            if (getCommand != null)
                getCommand.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully deleted user with id: " + userId)).build();
    }

    /**
     * Este endpoint actualiza un usuario
     *
     * @param userDto estructura de usuario a actualizar
     * @return CustomResponse con UserDto actualizado o excepcion
     */
    @PUT
    public Response updateUser(UserDto userDto) {
        User entity;
        UserDto responseDTO = null;
        UserDto ldapDto = null;
        UpdateUserCommand updateCommand = null;
        GetUserCommand getCommand = null;
        LdapUserManager ldap = new LdapUserManager();

        try {
            entity = UserMapper.mapDtoToEntity(userDto.getId());
            getCommand = CommandFactory.createGetUserCommand(entity);
            getCommand.execute();

            if (getCommand.getReturnParam() != null)
                ldapDto = UserMapper.mapEntityToDto(getCommand.getReturnParam());
            else
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method updateUser, user with id " + userDto.getId() + " could not be found")).build();

            entity = UserMapper.mapDtoToEntity(userDto);
            updateCommand = CommandFactory.createUpdateUserCommand(entity);
            updateCommand.execute();
            responseDTO = UserMapper.mapEntityToDto(updateCommand.getReturnParam());

            // Unicamente cambiar la contraseña en LDAP
            if (LdapUserManager.authUser(ldapDto.get_username(), ldapDto.get_password()))
                ldap.updateUserPassword(ldapDto.get_username(), userDto.get_password());

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method updateUser, user could not be updated: " + e.getMessage())).build();
        } finally {
            if (updateCommand != null)
                updateCommand.closeHandlerSession();
            if (getCommand != null)
                getCommand.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully modified the user with id: " + userDto.getId())).build();
    }
}
