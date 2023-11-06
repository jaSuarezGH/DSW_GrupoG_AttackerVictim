package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.CommandFactoryPersona;
import com.ucab.cmcapp.logic.commands.persona.composite.CreatePersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.GetPersonaCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.dtos.PersonaDTO;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.PersonaMapper;
import com.ucab.cmcapp.logic.mappers.UserMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/persona")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaService extends BaseService{

    @GET
    @Path("/{id}")
    public PersonaDTO getPersona(@PathParam("id") long personaId) {
        Persona entity;
        PersonaDTO response;
        GetPersonaCommand command = null;

        try {
            entity = PersonaMapper.mapDtoToEntity(personaId);
            command = CommandFactoryPersona.createGetPersonaCommand(entity);
            command.execute();
            response = PersonaMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity(e).build());
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return response;
    }

    @POST
    public PersonaDTO addPersona(PersonaDTO personaDto) {
        Persona entity;
        PersonaDTO response;
        CreatePersonaCommand command = null;


        try {
            entity = PersonaMapper.mapDtoToEntity(personaDto);
            command = CommandFactoryPersona.createCreatePersonaCommand(entity);
            command.execute();
            response = PersonaMapper.mapEntityToDto(command.getReturnParam());

        } catch (Exception e) {

            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity(e).build());
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }


        return response;
    }

}
