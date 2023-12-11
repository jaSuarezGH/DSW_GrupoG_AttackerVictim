package com.ucab.cmcapp.logic.commands.Incident.atomic;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.victim.atomic.AddVictimCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.IncidentDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddIncidentCommand extends Command<Incident> {

    private static Logger _logger = LoggerFactory.getLogger(AddIncidentCommand.class);
    private Incident _incident;
    private IncidentDao _dao;

    public AddIncidentCommand(Incident incident, DBHandler handler) {
        setHandler(handler);
        _incident = incident;
        _dao = DaoFactory.createIncidentDao(getHandler());
    }

    public AddIncidentCommand(Incident incident) {
        _incident = incident;
        setHandler(new DBHandler());
        _dao = DaoFactory.createIncidentDao(getHandler());
    }

    @Override
    public void execute() {
        _incident = _dao.insert(_incident);
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
