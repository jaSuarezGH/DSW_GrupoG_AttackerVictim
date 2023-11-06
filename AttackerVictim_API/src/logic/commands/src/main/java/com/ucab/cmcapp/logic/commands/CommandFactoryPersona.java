package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.persona.composite.CreatePersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.GetPersonaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.logic.commands.persona.atomic.AddPersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByIdCommand;

public class CommandFactoryPersona {

    public static GetPersonaCommand createGetPersonaCommand(Persona persona) {
        return new GetPersonaCommand(persona);
    }

    /*public static GetPersonaByEmailCommand createGetPersonaByEmailCommand(Persona persona) {
        return new GetPersonaByEmailCommand(persona);
    }*/

    public static GetPersonaByIdCommand createGetPersonaByIdCommand(DBHandler handler, long userId) {
        return new GetPersonaByIdCommand(handler, userId);
    }

    public static AddPersonaCommand createAddPersonaCommand(Persona persona, DBHandler handler) {
        return new AddPersonaCommand(persona, handler);
    }

    public static CreatePersonaCommand createCreatePersonaCommand(Persona persona) {
        return new CreatePersonaCommand(persona);
    }

}
