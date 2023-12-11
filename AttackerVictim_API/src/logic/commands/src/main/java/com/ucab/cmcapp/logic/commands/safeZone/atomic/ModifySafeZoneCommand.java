package com.ucab.cmcapp.logic.commands.safeZone.atomic;

import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.SafeZoneDao;
import com.ucab.cmcapp.persistence.dao.UserDao;

public class ModifySafeZoneCommand extends Command<SafeZone> {

    private SafeZone _safeZone;
    private SafeZoneDao _dao;

    public ModifySafeZoneCommand(SafeZone safeZone, DBHandler handler) {
        setHandler(handler);
        _safeZone = safeZone;
        _dao = DaoFactory.createSafeZoneDao(getHandler());
    }

    @Override
    public void execute() {
        _safeZone = _dao.update(_safeZone);
    }

    @Override
    public SafeZone getReturnParam() {
        return _safeZone;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
