package com.ucab.cmcapp.logic.commands.safeZone.atomic;

import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.SafeZoneDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;

import java.util.List;

public class GetAllSafeZoneListCommand extends Command<SafeZone> {

    private List<SafeZone> _result;
    private SafeZoneDao _dao;

    public GetAllSafeZoneListCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createSafeZoneDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(SafeZone.class);
    }

    @Override
    public List<SafeZone> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
