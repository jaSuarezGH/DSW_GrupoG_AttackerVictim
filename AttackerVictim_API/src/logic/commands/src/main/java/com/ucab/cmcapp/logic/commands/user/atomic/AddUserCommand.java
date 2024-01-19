package com.ucab.cmcapp.logic.commands.user.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddUserCommand extends Command<User> {

    private User _user;
    private UserDao _dao;

    public AddUserCommand(User user, DBHandler handler) {
        setHandler(handler);
        _user = user;
        _dao = DaoFactory.createUserDao(getHandler());
    }

    public AddUserCommand(User user) {
        _user = user;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUserDao(getHandler());
    }

    @Override
    public void execute() {
        _user = _dao.insert(_user);
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
