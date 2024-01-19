package com.ucab.cmcapp.logic.commands.user.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUserByEmailCommand extends Command<User> {
    private User _user;
    private UserDao _dao;

    public GetUserByEmailCommand(User user) {
        _user = user;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUserDao(getHandler());
    }

    public GetUserByEmailCommand(User user, DBHandler handler) {
        _user = user;
        setHandler(handler);
        _dao = DaoFactory.createUserDao(getHandler());
    }

    @Override
    public void execute() {
        _user = _dao.getUserByEmail(_user.get_email());
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
