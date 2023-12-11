package com.ucab.cmcapp.logic.commands.Incident.atomic;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.IncidentDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;

public class EraseIncidentCommand extends Command<Incident> {

    private Incident _incident;
    private IncidentDao _dao;

    public EraseIncidentCommand(Incident incident, DBHandler handler) {
        setHandler(handler);
        _incident = incident;
        _dao = DaoFactory.createIncidentDao(getHandler());
    }

    @Override
    public void execute() {
        _incident = _dao.delete(_incident);
    }

    @Override
    public Incident getReturnParam() {
        return _incident;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
