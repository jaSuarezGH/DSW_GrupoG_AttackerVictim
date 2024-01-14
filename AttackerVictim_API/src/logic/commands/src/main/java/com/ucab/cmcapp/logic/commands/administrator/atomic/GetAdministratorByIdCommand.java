package com.ucab.cmcapp.logic.commands.administrator.atomic;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministratorDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAdministratorByIdCommand extends Command<Administrator> {

    private static Logger _logger = LoggerFactory.getLogger(GetAdministratorByIdCommand.class);
    private long _administratorId;
    private Administrator _result;
    private AdministratorDao _dao;

    public GetAdministratorByIdCommand(DBHandler handler, long administratorId) {
        _administratorId = administratorId;
        setHandler(handler);
        _dao = DaoFactory.createAdministratorDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.find(_administratorId, Administrator.class);
    }

    @Override
    public Administrator getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
