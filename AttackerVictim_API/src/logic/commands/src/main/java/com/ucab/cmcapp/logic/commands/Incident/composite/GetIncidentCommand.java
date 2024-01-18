package com.ucab.cmcapp.logic.commands.Incident.composite;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.atomic.GetIncidentByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetIncidentCommand extends Command<Incident> {

    private Incident _incident;
    long _id;
    private GetIncidentByIdCommand _getIncidentByIdCommand;

    public GetIncidentCommand(Incident incident) {
        _id = incident.get_id();
        _incident = incident;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getIncidentByIdCommand = CommandFactory.createGetIncidentByIdCommand(getHandler(), _id);
            _getIncidentByIdCommand.execute();
            _incident = _getIncidentByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
