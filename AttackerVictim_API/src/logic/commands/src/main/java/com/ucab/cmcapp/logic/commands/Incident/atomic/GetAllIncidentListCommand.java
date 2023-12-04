package com.ucab.cmcapp.logic.commands.Incident.atomic;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.IncidentDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;

import java.util.List;

public class GetAllIncidentListCommand extends Command<Incident> {

    private List<Incident> _result;
    private IncidentDao _dao;

    public GetAllIncidentListCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createIncidentDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(Incident.class);
    }

    @Override
    public List<Incident> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
