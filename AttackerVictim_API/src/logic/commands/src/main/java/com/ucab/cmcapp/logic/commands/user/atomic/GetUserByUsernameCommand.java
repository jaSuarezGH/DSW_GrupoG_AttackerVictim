package com.ucab.cmcapp.logic.commands.user.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;

public class GetUserByUsernameCommand extends Command<User> {

    private User _user;
    private UserDao _dao;

    public GetUserByUsernameCommand(User user) {
        _user = user;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUserDao(getHandler());
    }

    @Override
    public void execute() {
        _user = _dao.getUserByUsername(_user.get_username());
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
