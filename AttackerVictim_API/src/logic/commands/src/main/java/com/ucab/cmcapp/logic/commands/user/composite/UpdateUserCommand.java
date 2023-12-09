package com.ucab.cmcapp.logic.commands.user.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.ModifyUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateUserCommand extends Command<User> {

    private User _user;
    private User _result;
    private ModifyUserCommand _modifyUserCommand;

    public UpdateUserCommand(User user) {
        _user = user;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifyUserCommand = CommandFactory.createModifyUserCommand(_user, getHandler());
            _modifyUserCommand.execute();
            _result = _modifyUserCommand.getReturnParam();
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
