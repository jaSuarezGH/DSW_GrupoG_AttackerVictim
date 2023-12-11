package com.ucab.cmcapp.logic.commands.safeZone.composite;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.history.atomic.AddHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.composite.CreateHistoryCommand;
import com.ucab.cmcapp.logic.commands.safeZone.atomic.AddSafeZoneCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateSafeZoneCommand extends Command<SafeZone> {

    private static Logger _logger = LoggerFactory.getLogger(CreateSafeZoneCommand.class);
    private SafeZone _safeZone;
    private SafeZone _result;
    private AddSafeZoneCommand _addSafeZoneCommand;

    public CreateSafeZoneCommand(SafeZone safeZone) {
        _safeZone = safeZone;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _addSafeZoneCommand = CommandFactory.createAddSafeZoneCommand(_safeZone, getHandler());
            _addSafeZoneCommand.execute();
            _result = _addSafeZoneCommand.getReturnParam();
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
