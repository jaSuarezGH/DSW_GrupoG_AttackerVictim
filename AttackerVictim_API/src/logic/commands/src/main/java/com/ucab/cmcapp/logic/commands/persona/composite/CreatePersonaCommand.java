package com.ucab.cmcapp.logic.commands.persona.composite;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.CommandFactoryPersona;
import com.ucab.cmcapp.logic.commands.persona.atomic.AddPersonaCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CreatePersonaCommand extends Command<Persona> {
    private Persona _persona;
    private Persona _result;
    private AddPersonaCommand _addPersonaCommand;

    public CreatePersonaCommand(Persona persona) {

        _persona = persona;
        setHandler(new DBHandler());

    }

    @Override
    public void execute() {

        try {
            getHandler().beginTransaction();
            _addPersonaCommand = CommandFactoryPersona.createAddPersonaCommand(_persona, getHandler());
            _addPersonaCommand.execute();
            _result = _addPersonaCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

    }

    @Override
    public Persona getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
