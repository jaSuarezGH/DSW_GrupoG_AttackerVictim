package com.ucab.cmcapp.logic.commands.persona.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;

public class GetPersonaByIdCommand extends Command<Persona> {
    private long _personaId;
    private Persona _result;
    private PersonaDao _dao;

    public GetPersonaByIdCommand(DBHandler handler, long personaId) {

        _personaId = personaId;
        setHandler(handler);
        _dao = DaoFactory.createPersonaDao(getHandler());

    }

    @Override
    public void execute() {

        _result = _dao.find(_personaId, Persona.class);

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
