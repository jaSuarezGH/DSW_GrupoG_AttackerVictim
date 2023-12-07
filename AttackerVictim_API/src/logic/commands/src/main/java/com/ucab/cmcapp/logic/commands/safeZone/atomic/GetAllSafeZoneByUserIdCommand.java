package com.ucab.cmcapp.logic.commands.safeZone.atomic;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.HistoryDao;
import com.ucab.cmcapp.persistence.dao.SafeZoneDao;

import java.util.List;

public class GetAllSafeZoneByUserIdCommand extends Command<SafeZone> {

    private SafeZone _safeZone;
    private List<SafeZone> _result;
    private SafeZoneDao _dao;

    public GetAllSafeZoneByUserIdCommand(SafeZone safeZone) {
        _safeZone = safeZone;
        setHandler(new DBHandler());
        _dao = DaoFactory.createSafeZoneDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.getAllSafeZoneByUserId(_safeZone.get_user());
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
