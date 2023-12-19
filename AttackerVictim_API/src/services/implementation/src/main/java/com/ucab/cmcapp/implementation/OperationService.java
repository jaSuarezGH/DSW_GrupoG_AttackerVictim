package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.atomic.GetIncidentByVictimIdCommand;
import com.ucab.cmcapp.logic.commands.operation.atomic.GetSeparationDistanceByIncidentIdCommand;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.IncidentDto;
import com.ucab.cmcapp.logic.mappers.HistoryMapper;
import com.ucab.cmcapp.logic.mappers.IncidentMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/operation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperationService extends BaseService {

    @GET
    @Path("/{incident_id}")
    public Response getSeparationDistanceByIncidentId(@PathParam("incident_id") long incidentId) {
        Incident entity;
        List<HistoryDto> responseDTO = null;
        GetSeparationDistanceByIncidentIdCommand command = null;

        try {
            entity = IncidentMapper.mapDtoToEntity(incidentId);
            command = CommandFactory.createGetSeparationDistanceByIncidentIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = HistoryMapper.mapEntityListToDtoList(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[GENERAL EXCEPTION] Could not calculate the separation distance with incident id: " + incidentId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getSeparationDistanceByIncidentId: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        // crear operation dtoy mover las cosas de lugar

        // CLASE QUE CALCULA

        // CALCULAR PASANDOLE LOS DTO...

        // DEVOLVER DISTANCIA DE SEPARACION EN CUSTOM DTO

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully calculated separation distance with incident id: " + incidentId)).build();
    }

}
