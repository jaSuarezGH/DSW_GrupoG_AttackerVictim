package com.ucab.cmcapp.logic.commands.user.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.GetAllUserListCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllUserCommand extends Command<User> {

    private List<User> _user;

    public GetAllUserCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            GetAllUserListCommand getAllUserListCommand = CommandFactory.createGetAllUserListCommand(getHandler());
            getAllUserListCommand.execute();
            _user = getAllUserListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<User> getReturnParam() {
        return _user;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
