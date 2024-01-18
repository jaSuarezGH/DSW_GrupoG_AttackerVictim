package com.ucab.cmcapp.logic.commands.safeZone.atomic;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.history.atomic.AddHistoryCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.HistoryDao;
import com.ucab.cmcapp.persistence.dao.SafeZoneDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddSafeZoneCommand extends Command<SafeZone> {

    private SafeZone _safeZone;
    private SafeZoneDao _dao;

    public AddSafeZoneCommand(SafeZone safeZone, DBHandler handler) {
        setHandler(handler);
        _safeZone = safeZone;
        _dao = DaoFactory.createSafeZoneDao(getHandler());
    }

    public AddSafeZoneCommand(SafeZone safeZone) {
        _safeZone = safeZone;
        setHandler(new DBHandler());
        _dao = DaoFactory.createSafeZoneDao(getHandler());
    }

    @Override
    public void execute() {
        _safeZone = _dao.insert(_safeZone);
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
