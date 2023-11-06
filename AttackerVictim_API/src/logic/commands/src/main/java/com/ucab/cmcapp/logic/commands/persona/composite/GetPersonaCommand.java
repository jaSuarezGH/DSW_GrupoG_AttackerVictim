package com.ucab.cmcapp.logic.commands.persona.composite;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactoryPersona;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class GetPersonaCommand extends Command<Persona> {

    private Persona _persona;
    long _id;

    public GetPersonaCommand(Persona persona) {
        _id = persona.get_id();
        _persona = persona;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            GetPersonaByIdCommand getPersonaByIdCommand = CommandFactoryPersona.createGetPersonaByIdCommand(getHandler(), _id);
            getPersonaByIdCommand.execute();
            _persona = getPersonaByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Persona getReturnParam() {
        return _persona;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
