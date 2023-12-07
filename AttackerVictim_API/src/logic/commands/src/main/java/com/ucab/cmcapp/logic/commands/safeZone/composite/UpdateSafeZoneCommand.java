package com.ucab.cmcapp.logic.commands.safeZone.composite;

import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.safeZone.atomic.ModifySafeZoneCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.ModifyUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateSafeZoneCommand extends Command<SafeZone> {

    private SafeZone _safeZone;
    private SafeZone _result;
    private ModifySafeZoneCommand _modifySafeZoneCommand;

    public UpdateSafeZoneCommand(SafeZone safeZone) {
        _safeZone = safeZone;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifySafeZoneCommand = CommandFactory.createModifySafeZoneCommand(_safeZone, getHandler());
            _modifySafeZoneCommand.execute();
            _result = _modifySafeZoneCommand.getReturnParam();
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
