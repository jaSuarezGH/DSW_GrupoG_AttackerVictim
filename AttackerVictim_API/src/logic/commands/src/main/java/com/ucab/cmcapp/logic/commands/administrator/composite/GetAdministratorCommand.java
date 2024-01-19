package com.ucab.cmcapp.logic.commands.administrator.composite;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrator.atomic.GetAdministratorByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAdministratorCommand extends Command<Administrator> {

    private Administrator _administrator;
    long _id;
    private GetAdministratorByIdCommand _getAdministratorByIdCommand;

    public GetAdministratorCommand(Administrator administrator) {
        _id = administrator.get_id();
        _administrator = administrator;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAdministratorByIdCommand = CommandFactory.createGetAdministratorByIdCommand(getHandler(), _id);
            _getAdministratorByIdCommand.execute();
            _administrator = _getAdministratorByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Administrator getReturnParam() {
        return _administrator;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
