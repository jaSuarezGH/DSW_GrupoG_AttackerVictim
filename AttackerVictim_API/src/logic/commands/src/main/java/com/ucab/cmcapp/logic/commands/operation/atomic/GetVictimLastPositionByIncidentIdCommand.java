package com.ucab.cmcapp.logic.commands.operation.atomic;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.IncidentDao;

public class GetVictimLastPositionByIncidentIdCommand extends Command<Incident> {

    private Incident _incident;
    private IncidentDao _dao;
    private History _result;

    public GetVictimLastPositionByIncidentIdCommand(Incident incident) {
        _incident = incident;
        setHandler(new DBHandler());
        _dao = DaoFactory.createIncidentDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.getVictimLastPositionByIncidentId(_incident);
    }

    @Override
    public History getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
