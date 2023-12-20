package com.ucab.cmcapp.logic.commands.Incident.atomic;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.IncidentDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetIncidentByIdCommand extends Command<Incident> {

    private static Logger _logger = LoggerFactory.getLogger(GetIncidentByIdCommand.class);
    private long _incidentId;
    private Incident _result;
    private IncidentDao _dao;

    public GetIncidentByIdCommand(DBHandler handler, long incidentId) {
        _incidentId = incidentId;
        setHandler(handler);
        _dao = DaoFactory.createIncidentDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.find(_incidentId, Incident.class);
    }

    @Override
    public Incident getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
