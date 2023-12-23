package com.ucab.cmcapp.logic.commands.Incident.composite;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.atomic.ModifyIncidentCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.ModifyUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateIncidentCommand extends Command<Incident> {

    private Incident _incident;
    private Incident _result;
    private ModifyIncidentCommand _modifyIncidentCommand;

    public UpdateIncidentCommand(Incident incident) {
        _incident = incident;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifyIncidentCommand = CommandFactory.createModifyIncidentCommand(_incident, getHandler());
            _modifyIncidentCommand.execute();
            _result = _modifyIncidentCommand.getReturnParam();
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
