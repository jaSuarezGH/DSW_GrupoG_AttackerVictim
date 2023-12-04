package com.ucab.cmcapp.logic.commands.Incident.composite;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.atomic.GetAllIncidentListCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.GetAllVictimListCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllIncidentCommand extends Command<Incident> {

    private List<Incident> _incident;
    private GetAllIncidentListCommand _getAllIncidentListCommand;

    public GetAllIncidentCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllIncidentListCommand = CommandFactory.createGetAllIncidentListCommand(getHandler());
            _getAllIncidentListCommand.execute();
            _incident = _getAllIncidentListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<Incident> getReturnParam() {
        return _incident;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
