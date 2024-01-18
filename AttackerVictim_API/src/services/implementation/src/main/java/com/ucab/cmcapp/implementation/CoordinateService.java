package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordinate.composite.CreateCoordinateCommand;
import com.ucab.cmcapp.logic.commands.coordinate.composite.GetAllCoordinateCommand;
import com.ucab.cmcapp.logic.commands.coordinate.composite.GetCoordinateCommand;
import com.ucab.cmcapp.logic.commands.history.composite.CreateHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.composite.GetAllHistoryCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.dtos.CoordinateDto;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.CoordinateMapper;
import com.ucab.cmcapp.logic.mappers.HistoryMapper;
import com.ucab.cmcapp.logic.mappers.UserMapper;
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

    /**
     * Este endpoint regresa todas las coordenadas que se usan o no en zonas seguras
     *
     * @return CustomResponse con lista de CoordinateDto o excepcion
     */
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

    /**
     * Este endpoint devuelve una coordenada por Id
     *
     * @param coordinateId id de coordenada a solicitar
     * @return CustomResponse con CoordinateDto o excepcion
     */
    @GET
    @Path("/{id}")
    public Response getCoordinateById(@PathParam("id") long coordinateId) {
        Coordinate entity;
        CoordinateDto responseDTO = null;
        GetCoordinateCommand command = null;

        try {
            entity = CoordinateMapper.mapDtoToEntity(coordinateId);
            command = CommandFactory.createGetCoordinateCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = CoordinateMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] No coordinate found for id: " + coordinateId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getCoordinateById: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully found coordinate with id: " + coordinateId)).build();
    }

    /**
     * Este endpoint agrega una coordenada
     *
     * @param coordinateDto estructura de la coordenada a agregar
     * @return CustomResponse con CoordinateDto o excepcion
     */
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
