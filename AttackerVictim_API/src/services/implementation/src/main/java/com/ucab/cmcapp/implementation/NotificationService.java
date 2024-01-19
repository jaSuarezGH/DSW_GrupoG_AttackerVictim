package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.composite.CreateIncidentCommand;
import com.ucab.cmcapp.logic.commands.Incident.composite.GetAllIncidentCommand;
import com.ucab.cmcapp.logic.commands.history.atomic.GetAllHistoryByUserIdCommand;
import com.ucab.cmcapp.logic.commands.notification.atomic.GetAllNotificationByUserIdCommand;
import com.ucab.cmcapp.logic.commands.notification.composite.CreateNotificationCommand;
import com.ucab.cmcapp.logic.commands.notification.composite.GetAllNotificationCommand;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import com.ucab.cmcapp.logic.dtos.NotificationDto;
import com.ucab.cmcapp.logic.mappers.HistoryMapper;
import com.ucab.cmcapp.logic.mappers.IncidentMapper;
import com.ucab.cmcapp.logic.mappers.NotificationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notification")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationService extends BaseService {

    /**
     * Este endpoint consulta todas las notificaciones
     *
     * @return CustomResponse con lista de NotificationDto o null o excepcion
     */
    @GET
    @Path("/all")
    public Response getAllNotifications() {
        List<NotificationDto> responseDTO = null;
        GetAllNotificationCommand command = null;

        try {
            command = CommandFactory.createGetAllNotificationCommand();
            command.execute();
            responseDTO = NotificationMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty())
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] Currently there are no notifications in database")).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllNotifications: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully listed all notifications")).build();
    }

    /**
     * Este endpoint consulta todas las notificaciones segun un id de usuario
     *
     * @param userId id de usario a obtener notificaciones
     * @return CustomResponse con lista de NotificationDto o null o excepcion
     */
    @GET
    @Path("/{user_id}")
    public Response getAllNotificationByUserId(@PathParam("user_id") long userId) {
        Notification entity;
        List<NotificationDto> responseDTO = null;
        GetAllNotificationByUserIdCommand command = null;

        try {
            entity = NotificationMapper.mapDtoToEntityUserId(userId);
            command = CommandFactory.createGetAllNotificationByUserIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = NotificationMapper.mapEntityListToDtoList(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No notifications found for user_id: " + userId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllNotificationByUserId: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found all notifications with user_id: " + userId)).build();
    }

    /**
     * Este endpoint agrega una notificacion
     *
     * @param notificationDto estructura de notificacion a agregar
     * @return CustomResponse con NotificationDto agregada o excepcion
     */
    @POST
    public Response addNotification(NotificationDto notificationDto) {
        Notification entity;
        NotificationDto responseDTO = null;
        CreateNotificationCommand command = null;

        try {
            entity = NotificationMapper.mapDtoToEntity(notificationDto);
            command = CommandFactory.createCreateNotificationCommand(entity);
            command.execute();
            responseDTO = NotificationMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method addNotification, notification could not be added: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] notification created successfully")).build();
    }


}
