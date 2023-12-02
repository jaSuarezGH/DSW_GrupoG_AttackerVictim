package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.composite.GetAllUserCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.GetAllVictimCommand;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.VictimDto;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import com.ucab.cmcapp.logic.mappers.VictimMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/victim")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VictimService extends BaseService {

    private static Logger _logger = LoggerFactory.getLogger(VictimService.class);

    @GET
    @Path("/all")
    public Response getAllVictims() {
        List<VictimDto> responseDTO = null;
        GetAllVictimCommand command = null;

        try {
            command = CommandFactory.createGetAllVictimCommand();
            command.execute();
            responseDTO = VictimMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty())
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[OK EMPTY RESPONSE] Currently there are no victims in database")).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getAllVictims: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "[OK NORMAL RESPONSE] Successfully listed all victims")).build();
    }

}
