package com.ucab.cmcapp.logic.commands.administrator.composite;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrator.atomic.AddAdministratorCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAdministratorCommand extends Command<Administrator> {

    private static Logger _logger = LoggerFactory.getLogger(CreateAdministratorCommand.class);
    private Administrator _administrator;
    private Administrator _result;
    private AddAdministratorCommand _addAdministratorCommand;

    public CreateAdministratorCommand(Administrator administrator) {
        _administrator = administrator;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _addAdministratorCommand = CommandFactory.createAddAdministratorCommand(_administrator, getHandler());
            _addAdministratorCommand.execute();
            _result = _addAdministratorCommand.getReturnParam();
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
