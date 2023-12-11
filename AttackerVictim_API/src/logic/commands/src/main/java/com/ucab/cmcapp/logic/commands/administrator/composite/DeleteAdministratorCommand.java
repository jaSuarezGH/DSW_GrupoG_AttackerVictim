package com.ucab.cmcapp.logic.commands.administrator.composite;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrator.atomic.EraseAdministratorCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.EraseUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteAdministratorCommand extends Command<Administrator> {

    private Administrator _administrator;
    private Administrator _result;
    private EraseAdministratorCommand _eraseAdministratorCommand;

    public DeleteAdministratorCommand(Administrator administrator) {
        _administrator = administrator;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseAdministratorCommand = CommandFactory.createEraseAdministratorCommand(_administrator, getHandler());
            _eraseAdministratorCommand.execute();
            _result = _eraseAdministratorCommand.getReturnParam();
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
