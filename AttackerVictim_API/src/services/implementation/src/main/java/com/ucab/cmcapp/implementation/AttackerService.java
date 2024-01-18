package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.attacker.atomic.GetAttackerByUserIdCommand;
import com.ucab.cmcapp.logic.commands.attacker.composite.CreateAttackerCommand;
import com.ucab.cmcapp.logic.commands.attacker.composite.DeleteAttackerCommand;
import com.ucab.cmcapp.logic.commands.attacker.composite.GetAllAttackerCommand;
import com.ucab.cmcapp.logic.dtos.AttackerDto;
import com.ucab.cmcapp.logic.mappers.AttackerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/attacker")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AttackerService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(AttackerService.class);

    /**
     * Este metodo devuelve todos los atacantes registrados
     *
     * @return CustomResponse con AttackerDto o excepcion
     */
    @GET
    @Path("/all")
    public Response getAllAttackers() {
        List<AttackerDto> responseDTO = null;
        GetAllAttackerCommand command = null;

        try {
            command = CommandFactory.createGetAllAttackerCommand();
            command.execute();
            responseDTO = AttackerMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty())
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] Currently there are no attackers in database")).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllAttackers: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully listed all attackers")).build();
    }

    /**
     * Este metodo devuelve un objeto atacante a partir de su id de usuario
     *
     * @param userId id de usuario
     * @return CustomResponse con AttackerDto o excepcion
     */
    @GET
    @Path("/{user_id}")
    public Response getAttackerByUserId(@PathParam("user_id") long userId) {
        Attacker entity;
        AttackerDto responseDTO = null;
        GetAttackerByUserIdCommand command = null;

        try {
            entity = AttackerMapper.mapDtoToEntityUserId(userId);
            command = CommandFactory.createGetAttackerByUserIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AttackerMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No attacker found for user_id: " + userId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAttackerByUserId: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found attacker with user_id: " + userId)).build();
    }

    /**
     * Este endpoint agrega un atacante
     *
     * @param attackerDto estrucutra de atacante a agregar
     * @return CustomResponse con AttackerDto o excepcion
     */
    @POST
    public Response addAttacker(AttackerDto attackerDto) {
        Attacker entity;
        AttackerDto responseDTO = null;
        CreateAttackerCommand command = null;

        try {
            entity = AttackerMapper.mapDtoToEntity(attackerDto);
            command = CommandFactory.createCreateAttackerCommand(entity);
            command.execute();
            responseDTO = AttackerMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method addAttacker, attacker could not be added: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] attacker created successfully")).build();
    }

    /**
     * Este endpoint elimina un atacante
     *
     * @param attackerId id del atacante a eliminar
     * @return CustomResponse con AttackerDto o excepcion
     */
    @DELETE
    @Path("/{id}")
    public Response deleteAttacker(@PathParam("id") long attackerId) {
        Attacker entity;
        AttackerDto responseDTO;
        DeleteAttackerCommand command = null;

        try {
            entity = AttackerMapper.mapDtoToEntity(attackerId);
            command = CommandFactory.createDeleteAttackerCommand(entity);
            command.execute();
            entity = command.getReturnParam();
            responseDTO = AttackerMapper.mapEntityToDto(entity);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method deleteAttacker, attacker could not be deleted: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully deleted attacker registry with id: " + attackerId)).build();
    }
}
