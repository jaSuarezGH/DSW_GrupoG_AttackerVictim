package com.ucab.cmcapp.logic.commands.user.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;

public class GetUserByPersonalIdCommand extends Command<User> {

    private User _user;
    private UserDao _dao;

    public GetUserByPersonalIdCommand(User user) {
        _user = user;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUserDao(getHandler());
    }

    @Override
    public void execute() {
        _user = _dao.getUserByPersonalId(_user.get_personal_id());
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
