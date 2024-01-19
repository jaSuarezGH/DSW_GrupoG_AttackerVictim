package com.ucab.cmcapp.logic.commands.user.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUserByIdCommand extends Command<User> {

    private long _userId;
    private User _result;
    private UserDao _dao;

    public GetUserByIdCommand(DBHandler handler, long userId) {
        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createUserDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.find(_userId, User.class);
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
