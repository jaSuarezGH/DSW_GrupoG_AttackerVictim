package com.ucab.cmcapp.logic.commands.administrator.composite;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.atomic.ModifyIncidentCommand;
import com.ucab.cmcapp.logic.commands.administrator.atomic.ModifyAdministratorCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateAdministratorCommand extends Command<Administrator> {

    private Administrator _administrator;
    private Administrator _result;
    private ModifyAdministratorCommand _modifyAdministratorCommand;

    public UpdateAdministratorCommand(Administrator administrator) {
        _administrator = administrator;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifyAdministratorCommand = CommandFactory.createModifyAdministratorCommand(_administrator, getHandler());
            _modifyAdministratorCommand.execute();
            _result = _modifyAdministratorCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Administrator getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
