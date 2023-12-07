package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordinate.composite.CreateCoordinateCommand;
import com.ucab.cmcapp.logic.commands.coordinate.composite.GetAllCoordinateCommand;
import com.ucab.cmcapp.logic.commands.history.composite.CreateHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.composite.GetAllHistoryCommand;
import com.ucab.cmcapp.logic.dtos.CoordinateDto;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.mappers.CoordinateMapper;
import com.ucab.cmcapp.logic.mappers.HistoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/coordinate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoordinateService extends BaseService {

    private static Logger _logger = LoggerFactory.getLogger(CoordinateService.class);

    @GET
    @Path("/all")
    public Response getAllCoordinates() {
        List<CoordinateDto> responseDTO = null;
        GetAllCoordinateCommand command = null;

        try {
            command = CommandFactory.createGetAllCoordinateCommand();
            command.execute();
            responseDTO = CoordinateMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty())
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] Currently there is no coordinates in database")).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllCoordinates: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully listed all coordinates")).build();
    }

    @POST
    public Response addCoordinate(CoordinateDto coordinateDto) {
        Coordinate entity;
        CoordinateDto responseDTO = null;
        CreateCoordinateCommand command = null;

        try {
            entity = CoordinateMapper.mapDtoToEntity(coordinateDto);
            command = CommandFactory.createCreateCoordinateCommand(entity);
            command.execute();
            responseDTO = CoordinateMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method addCoordinate, coordinate could not be added: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] coordinate created successfully")).build();
    }

}
