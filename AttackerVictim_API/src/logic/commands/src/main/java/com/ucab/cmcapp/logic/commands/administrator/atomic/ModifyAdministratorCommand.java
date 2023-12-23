package com.ucab.cmcapp.logic.commands.administrator.atomic;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministratorDao;
import com.ucab.cmcapp.persistence.dao.IncidentDao;

public class ModifyAdministratorCommand extends Command<Administrator> {

    private Administrator _administrator;
    private AdministratorDao _dao;

    public ModifyAdministratorCommand(Administrator administrator, DBHandler handler) {
        setHandler(handler);
        _administrator = administrator;
        _dao = DaoFactory.createAdministratorDao(getHandler());
    }

    @Override
    public void execute() {
        _administrator = _dao.update(_administrator);
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
