package com.ucab.cmcapp.logic.commands.persona.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;

public class AddPersonaCommand extends Command<Persona> {

    private Persona _persona;
    private PersonaDao _dao;

    public AddPersonaCommand(Persona persona, DBHandler handler) {
        setHandler(handler);
        _persona = persona;
        _dao = DaoFactory.createPersonaDao(getHandler());
    }

    public AddPersonaCommand(Persona persona) {
        _persona = persona;
        setHandler(new DBHandler());
        _dao = DaoFactory.createPersonaDao(getHandler());
    }

    @Override
    public void execute() {

        _persona = _dao.insert(_persona);

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
