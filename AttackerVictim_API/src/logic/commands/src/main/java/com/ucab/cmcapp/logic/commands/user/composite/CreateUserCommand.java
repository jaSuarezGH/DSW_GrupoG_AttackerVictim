package com.ucab.cmcapp.logic.commands.user.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateUserCommand extends Command<User> {
    private User _user;
    private User _result;
    private AddUserCommand _addUserCommand;

    public CreateUserCommand(User user) {
        _user = user;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _addUserCommand = CommandFactory.createAddUserCommand(_user, getHandler());
            _addUserCommand.execute();
            _result = _addUserCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public User getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
