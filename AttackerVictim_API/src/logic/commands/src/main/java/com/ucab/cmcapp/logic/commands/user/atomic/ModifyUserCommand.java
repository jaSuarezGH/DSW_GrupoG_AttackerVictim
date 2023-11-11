package com.ucab.cmcapp.logic.commands.user.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;

public class ModifyUserCommand extends Command<User> {

    private User _user;
    private UserDao _dao;

    public ModifyUserCommand(User user, DBHandler handler) {
        setHandler(handler);
        _user = user;
        _dao = DaoFactory.createUserDao(getHandler());
    }

    @Override
    public void execute() {
        _user = _dao.update(_user);
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
