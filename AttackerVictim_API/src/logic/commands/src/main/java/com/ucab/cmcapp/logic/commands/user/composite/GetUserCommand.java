package com.ucab.cmcapp.logic.commands.user.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUserCommand extends Command<User> {
    private static Logger _logger = LoggerFactory.getLogger(GetUserCommand.class);
    private User _user;
    long _id;
    private GetUserByIdCommand _getUserByIdCommand;

    public GetUserCommand(User user) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetUserCommand.ctor: parameter {%s}",
                user.toString()));
        _id = user.get_id();
        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetUserCommand.ctor: attribute {%s}",
                _user.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            _getUserByIdCommand = CommandFactory.createGetUserByIdCommand(getHandler(), _id);
            _getUserByIdCommand.execute();
            _user = _getUserByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public User getReturnParam() {
        return _user;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
