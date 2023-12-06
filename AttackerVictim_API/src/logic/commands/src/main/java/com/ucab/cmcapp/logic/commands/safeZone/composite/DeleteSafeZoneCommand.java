package com.ucab.cmcapp.logic.commands.safeZone.composite;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.history.atomic.EraseHistoryCommand;
import com.ucab.cmcapp.logic.commands.safeZone.atomic.EraseSafeZoneCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteSafeZoneCommand extends Command<SafeZone> {

    private SafeZone _safeZone;
    private SafeZone _result;
    private EraseSafeZoneCommand _eraseSafeZoneCommand;

    public DeleteSafeZoneCommand(SafeZone safeZone) {
        _safeZone = safeZone;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseSafeZoneCommand = CommandFactory.createEraseSafeZoneCommand(_safeZone, getHandler());
            _eraseSafeZoneCommand.execute();
            _result = _eraseSafeZoneCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public SafeZone getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
