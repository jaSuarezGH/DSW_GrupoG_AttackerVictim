package com.ucab.cmcapp.logic.commands.user.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;

import java.util.List;

public class GetAllUserListCommand extends Command<User> {

    private List<User> _result;
    private UserDao _dao;

    public GetAllUserListCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createUserDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(User.class);
    }

    @Override
    public List<User> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
