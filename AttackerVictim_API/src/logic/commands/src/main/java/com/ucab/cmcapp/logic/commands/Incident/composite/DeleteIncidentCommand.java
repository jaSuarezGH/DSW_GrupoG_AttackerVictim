package com.ucab.cmcapp.logic.commands.Incident.composite;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.atomic.EraseIncidentCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.EraseVictimCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteIncidentCommand extends Command<Incident> {

    private Incident _incident;
    private Incident _result;
    private EraseIncidentCommand _eraseIncidentCommand;

    public DeleteIncidentCommand(Incident incident) {
        _incident = incident;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseIncidentCommand = CommandFactory.createEraseIncidentCommand(_incident, getHandler());
            _eraseIncidentCommand.execute();
            _result = _eraseIncidentCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
