package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.history.composite.CreateHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.composite.DeleteHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.composite.GetAllHistoryCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.CreateVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.DeleteVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.GetAllVictimCommand;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import com.ucab.cmcapp.logic.mappers.HistoryMapper;
import com.ucab.cmcapp.logic.mappers.VictimMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/history")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoryService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(HistoryService.class);

    @GET
    @Path("/all")
    public Response getAllHistories() {
        List<HistoryDto> responseDTO = null;
        GetAllHistoryCommand command = null;

        try {
            command = CommandFactory.createGetAllHistoryCommand();
            command.execute();
            responseDTO = HistoryMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty())
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] Currently there is no histories in database")).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllHistories: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully listed all histories")).build();
    }

    // get custom de user id aqui ***********************

    @POST
    public Response addHistory(HistoryDto historyDto) {
        History entity;
        HistoryDto responseDTO = null;
        CreateHistoryCommand command = null;

        try {
            entity = HistoryMapper.mapDtoToEntity(historyDto);
            command = CommandFactory.createCreateHistoryCommand(entity);
            command.execute();
            responseDTO = HistoryMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method addHistory, history could not be added: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] history created successfully")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteHistory(@PathParam("id") long historyId) {
        History entity;
        HistoryDto responseDTO;
        DeleteHistoryCommand command = null;

        try {
            entity = HistoryMapper.mapDtoToEntity(historyId);
            command = CommandFactory.createDeleteHistoryCommand(entity);
            command.execute();
            entity = command.getReturnParam();
            responseDTO = HistoryMapper.mapEntityToDto(entity);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method deleteHistory, history could not be deleted: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully deleted history registry with id: " + historyId)).build();
    }

}
