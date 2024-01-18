package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrator.atomic.GetAdministratorByEmailCommand;
import com.ucab.cmcapp.logic.commands.administrator.atomic.GetAdministratorByUsernameCommand;
import com.ucab.cmcapp.logic.commands.administrator.composite.*;
import com.ucab.cmcapp.logic.dtos.AdministratorDto;
import com.ucab.cmcapp.logic.dtos.AdministratorLoginDto;
import com.ucab.cmcapp.logic.mappers.AdministratorMapper;
import com.ucab.cmcapp.logic.utilities.LdapAdministratorManager;
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

    /**
     * Este endpoint autentica a un administrador usando LDAP
     *
     * @param administratorLoginDto datos para el login
     * @return CustomResponse con true, false o excepcion
     */
    @POST
    @Path("/auth")
    public Response authUser(AdministratorLoginDto administratorLoginDto) {
        try {
            if (LdapAdministratorManager.authAdministrator(administratorLoginDto.get_username(), administratorLoginDto.get_password())) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>(true, "[OK POSITIVE RESPONSE] administrator authenticated successfully")).build();
            } else {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>(false, "[OK NEGATIVE RESPONSE] administrator could not be authenticated")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method authAdministrator, administrator could not be authenticated: " + e.getMessage())).build();
        }
    }

    /**
     * Este endpoint devuelve un administrador por su id
     *
     * @param administratorId id del administrador a consultar
     * @return CustomResponse con AdministratorDto o null o excepcion
     */
    @GET
    @Path("/{id}")
    public Response getAdministratorById(@PathParam("id") long administratorId) {
        Administrator entity;
        AdministratorDto responseDTO = null;
        GetAdministratorCommand command = null;

        try {
            entity = AdministratorMapper.mapDtoToEntity(administratorId);
            command = CommandFactory.createGetAdministratorCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AdministratorMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No administrator found for id: " + administratorId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAdministratorById: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found user with id: " + administratorId)).build();
    }

    /**
     * Este endpoint devuelve todos los administradores
     *
     * @return CustomResponse con lista de AdministratorDto o null o excepcion
     */
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

    /**
     * Este endpoint consulta un administrador por email
     *
     * @param administratorEmail email de administrador
     * @return CustomResponse con AdministratorDto o null o excepcion
     */
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

    /**
     * Este endpoint consulta un administrador por username
     *
     * @param username username de administrador
     * @return CustomResponse con AdministratorDto o null o excepcion
     */
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

    /**
     * Este endpoint agrega un administrador
     *
     * @param administratorDto estructura de administrador
     * @return CustomResponse con AdministratorDto o excepcion
     */
    @POST
    public Response addAdministrator(AdministratorDto administratorDto) {
        Administrator entity;
        AdministratorDto responseDTO = null;
        CreateAdministratorCommand command = null;
        LdapAdministratorManager ldap = new LdapAdministratorManager();

        try {
            entity = AdministratorMapper.mapDtoToEntity(administratorDto);
            command = CommandFactory.createCreateAdministratorCommand(entity);
            command.execute();
            responseDTO = AdministratorMapper.mapEntityToDto(command.getReturnParam());

            // Agregar usuario en LDAP
            if (!LdapAdministratorManager.authAdministrator(administratorDto.get_username(), administratorDto.get_password()))
                ldap.addAdministrator(administratorDto.get_username(), administratorDto.get_password());

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method addAdministrator, administrator could not be added: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] administrator created successfully")).build();
    }

    /**
     * Este endpoint elimina un administrador por id
     *
     * @param administratorId id de administrador
     * @return CustomResponse con AdministratorDto o excepcion
     */
    @DELETE
    @Path("/{id}")
    public Response deleteAdministrator(@PathParam("id") long administratorId) {
        Administrator entity;
        AdministratorDto responseDTO = null;
        AdministratorDto ldapDto = null;
        GetAdministratorCommand getCommand = null;
        DeleteAdministratorCommand deleteCommand = null;
        LdapAdministratorManager ldap = new LdapAdministratorManager();

        try {
            entity = AdministratorMapper.mapDtoToEntity(administratorId);
            getCommand = CommandFactory.createGetAdministratorCommand(entity);
            getCommand.execute();

            if (getCommand.getReturnParam() != null)
                ldapDto = AdministratorMapper.mapEntityToDto(getCommand.getReturnParam());
            else
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method deleteAdministrator, administrator with id " + administratorId + " could not be found")).build();

            entity = AdministratorMapper.mapDtoToEntity(administratorId);
            deleteCommand = CommandFactory.createDeleteAdministratorCommand(entity);
            deleteCommand.execute();
            responseDTO = AdministratorMapper.mapEntityToDto(deleteCommand.getReturnParam());

            // Eliminar administrador de LDAP
            if (LdapAdministratorManager.authAdministrator(ldapDto.get_username(), ldapDto.get_password()))
                ldap.deleteAdministrator(ldapDto.get_username());

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method deleteAdministrator, administrator could not be deleted: " + e.getMessage())).build();
        } finally {
            if (deleteCommand != null)
                deleteCommand.closeHandlerSession();
            if (getCommand != null)
                getCommand.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully deleted administrator with id: " + administratorId)).build();
    }

    /**
     * Este endpoint actualiza un administrador
     *
     * @param administratorDto estructura de administrador a actualizar
     * @return CustomResponse con AdministratorDto o excepcion
     */
    @PUT
    public Response updateAdministrator(AdministratorDto administratorDto) {
        Administrator entity;
        AdministratorDto responseDTO = null;
        AdministratorDto ldapDto = null;
        UpdateAdministratorCommand updateCommand = null;
        GetAdministratorCommand getCommand = null;
        LdapAdministratorManager ldap = new LdapAdministratorManager();

        try {
            entity = AdministratorMapper.mapDtoToEntity(administratorDto.getId());
            getCommand = CommandFactory.createGetAdministratorCommand(entity);
            getCommand.execute();

            if (getCommand.getReturnParam() != null)
                ldapDto = AdministratorMapper.mapEntityToDto(getCommand.getReturnParam());
            else
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method updateAdministrator, administrator with id " + administratorDto.getId() + " could not be found")).build();

            entity = AdministratorMapper.mapDtoToEntity(administratorDto);
            updateCommand = CommandFactory.createUpdateAdministratorCommand(entity);
            updateCommand.execute();
            responseDTO = AdministratorMapper.mapEntityToDto(updateCommand.getReturnParam());

            // Unicamente cambiar la contraseña en LDAP
            if (LdapAdministratorManager.authAdministrator(ldapDto.get_username(), ldapDto.get_password()))
                ldap.updateAdministratorPassword(ldapDto.get_username(), administratorDto.get_password());

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method updateAdministrator, administrator could not be updated: " + e.getMessage())).build();
        } finally {
            if (updateCommand != null)
                updateCommand.closeHandlerSession();
            if (getCommand != null)
                getCommand.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully modified administrator with id: " + administratorDto.getId())).build();
    }

}
