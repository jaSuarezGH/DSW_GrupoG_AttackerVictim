package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.composite.CreateIncidentCommand;
import com.ucab.cmcapp.logic.commands.Incident.composite.GetAllIncidentCommand;
import com.ucab.cmcapp.logic.commands.notification.composite.CreateNotificationCommand;
import com.ucab.cmcapp.logic.commands.notification.composite.GetAllNotificationCommand;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import com.ucab.cmcapp.logic.dtos.NotificationDto;
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

    private static Logger _logger = LoggerFactory.getLogger(NotificationService.class);

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
