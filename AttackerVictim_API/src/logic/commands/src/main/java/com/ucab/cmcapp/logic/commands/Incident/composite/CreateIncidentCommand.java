package com.ucab.cmcapp.logic.commands.Incident.composite;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.atomic.AddIncidentCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.AddVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.CreateVictimCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateIncidentCommand extends Command<Incident> {

    private Incident _incident;
    private Incident _result;
    private AddIncidentCommand _addIncidentCommand;

    public CreateIncidentCommand(Incident incident) {
        _incident = incident;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _addIncidentCommand = CommandFactory.createAddIncidentCommand(_incident, getHandler());
            _addIncidentCommand.execute();
            _result = _addIncidentCommand.getReturnParam();
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
