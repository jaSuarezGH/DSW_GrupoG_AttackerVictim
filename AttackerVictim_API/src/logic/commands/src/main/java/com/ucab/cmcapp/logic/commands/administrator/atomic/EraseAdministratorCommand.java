package com.ucab.cmcapp.logic.commands.administrator.atomic;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministratorDao;
import com.ucab.cmcapp.persistence.dao.UserDao;

public class EraseAdministratorCommand extends Command<Administrator> {

    private Administrator _administrator;
    private AdministratorDao _dao;

    public EraseAdministratorCommand(Administrator administrator, DBHandler handler) {
        setHandler(handler);
        _administrator = administrator;
        _dao = DaoFactory.createAdministratorDao(getHandler());
    }

    @Override
    public void execute() {
        _administrator = _dao.delete(_administrator);
    }

    @Override
    public Administrator getReturnParam() {
        return _administrator;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
