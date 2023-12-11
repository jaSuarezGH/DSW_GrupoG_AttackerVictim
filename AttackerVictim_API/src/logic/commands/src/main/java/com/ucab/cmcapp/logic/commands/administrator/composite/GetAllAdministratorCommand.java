package com.ucab.cmcapp.logic.commands.administrator.composite;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrator.atomic.GetAllAdministratorListCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetAllUserListCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllAdministratorCommand extends Command<Administrator> {

    private List<Administrator> _administrator;
    private GetAllAdministratorListCommand _getAllAdministratorListCommand;

    public GetAllAdministratorCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllAdministratorListCommand = CommandFactory.createGetAllAdministratorListCommand(getHandler());
            _getAllAdministratorListCommand.execute();
            _administrator = _getAllAdministratorListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<Administrator> getReturnParam() {
        return _administrator;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
