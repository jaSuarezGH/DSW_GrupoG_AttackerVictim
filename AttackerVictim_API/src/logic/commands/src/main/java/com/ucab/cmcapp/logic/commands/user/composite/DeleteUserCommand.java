package com.ucab.cmcapp.logic.commands.user.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.EraseUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteUserCommand extends Command<User> {

    private User _user;
    private User _result;

    private EraseUserCommand _eraseUserCommand;

    public DeleteUserCommand(User user) {
        _user = user;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseUserCommand = CommandFactory.createEraseUserCommand(_user, getHandler());
            _eraseUserCommand.execute();
            _result = _eraseUserCommand.getReturnParam();
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
