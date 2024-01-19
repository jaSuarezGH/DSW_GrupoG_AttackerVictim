package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.atomic.GetIncidentByAttackerIdCommand;
import com.ucab.cmcapp.logic.commands.Incident.atomic.GetIncidentByVictimIdCommand;
import com.ucab.cmcapp.logic.commands.Incident.composite.*;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.UpdateUserCommand;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.IncidentMapper;
import com.ucab.cmcapp.logic.mappers.UserMapper;
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

    /**
     * Este endpoint devuelve todas las relaciones victima-atacante (incidente)
     *
     * @return CustomResponse con lista de IncidentDto o null o exception
     */
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

    /**
     * Este endpoint consulta un incidente por su id
     *
     * @param incidentId id de incidente a consultar
     * @return CustomResponse con IncidentDto cosnultado o null o excepcion
     */
    @GET
    @Path("/{id}")
    public Response getIncidentById(@PathParam("id") long incidentId) {
        Incident entity;
        IncidentDto responseDTO = null;
        GetIncidentCommand command = null;

        try {
            entity = IncidentMapper.mapDtoToEntity(incidentId);
            command = CommandFactory.createGetIncidentCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = IncidentMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No victim-attacker relationships found for id: " + incidentId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getIncidentById: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found victim-attacker relationships with id: " + incidentId)).build();
    }

    /**
     * Este endpoint consulta un incidente segun el id de victima
     *
     * @param victimId id de victima a obtener su incidente
     * @return CustomResponse con IncidentDto o null o excepcion
     */
    @GET
    @Path("victimRegistry/{victim_id}")
    public Response getIncidentByVictimId(@PathParam("victim_id") long victimId) {
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

    /**
     * Este endpoint consulta un incidente por id de atacante
     *
     * @param attackerId id de atacante a obtener su id
     * @return CustomResponse con IncidentDto o null o excepcion
     */
    @GET
    @Path("attackerRegistry/{attacker_id}")
    public Response getIncidentByAttackerId(@PathParam("attacker_id") long attackerId) {
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

    /**
     * Este endpoint agrega un incidente
     *
     * @param incidentDto estructura de incidente a agregar
     * @return CustomResponse con incidentDto del incidente agregado o excepcion
     */
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

    /**
     * Este endpoint elimina un incidente por id
     *
     * @param incidentId id del incidente a eliminar
     * @return CustomResponse con incidentDto del incidente eliminado o excepcion
     */
    @DELETE
    @Path("/{id}")
    public Response deleteIncident(@PathParam("id") long incidentId) {
        Incident entity;
        IncidentDto responseDTO;
        DeleteIncidentCommand command = null;

        try {
            entity = IncidentMapper.mapDtoToEntity(incidentId);
            command = CommandFactory.createDeleteIncidentCommand(entity);
            command.execute();
            entity = command.getReturnParam();
            responseDTO = IncidentMapper.mapEntityToDto(entity);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method deleteIncident, relationship attacker-victim could not be deleted: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully deleted relationship attacker-victim registry with id: " + incidentId)).build();
    }

    /**
     * Este endpoint actualiza un incidente
     *
     * @param incidentDto estructura de incidente
     * @return CustomResponse con incidentDto con el incidente actualizado o excepcion
     */
    @PUT
    public Response updateIncident(IncidentDto incidentDto) {
        Incident entity;
        IncidentDto responseDTO = null;
        UpdateIncidentCommand command = null;
        try {
            entity = IncidentMapper.mapDtoToEntity(incidentDto);
            command = CommandFactory.createUpdateIncidentCommand(entity);
            command.execute();
            responseDTO = IncidentMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method updateIncident, relationship attacker-victim could not be updated: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully modified relationship attacker-victim with id: " + incidentDto.getId())).build();
    }

}
