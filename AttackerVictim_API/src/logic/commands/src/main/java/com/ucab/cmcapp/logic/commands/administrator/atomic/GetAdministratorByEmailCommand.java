package com.ucab.cmcapp.logic.commands.administrator.atomic;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministratorDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAdministratorByEmailCommand extends Command<Administrator> {

    private Administrator _administrator;
    private AdministratorDao _dao;

    public GetAdministratorByEmailCommand(Administrator administrator) {
        _administrator = administrator;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAdministratorDao(getHandler());
    }

    public GetAdministratorByEmailCommand(Administrator administrator, DBHandler handler) {
        _administrator = administrator;
        setHandler(handler);
        _dao = DaoFactory.createAdministratorDao(getHandler());
    }

    @Override
    public void execute() {
        _administrator = _dao.getAdministratorByEmail(_administrator.get_email());
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
