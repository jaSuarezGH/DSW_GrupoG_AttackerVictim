package com.ucab.cmcapp.logic.commands.administrator.atomic;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministratorDao;
import com.ucab.cmcapp.persistence.dao.UserDao;

import java.util.List;

public class GetAllAdministratorListCommand extends Command<Administrator> {

    private List<Administrator> _result;
    private AdministratorDao _dao;

    public GetAllAdministratorListCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createAdministratorDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(Administrator.class);
    }

    @Override
    public List<Administrator> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
