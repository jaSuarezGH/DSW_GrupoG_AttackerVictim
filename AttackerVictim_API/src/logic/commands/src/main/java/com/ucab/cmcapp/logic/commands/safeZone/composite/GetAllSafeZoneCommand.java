package com.ucab.cmcapp.logic.commands.safeZone.composite;

import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.safeZone.atomic.GetAllSafeZoneListCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.GetAllVictimListCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllSafeZoneCommand extends Command<SafeZone> {

    private List<SafeZone> _safeZone;
    private GetAllSafeZoneListCommand _getAllSafeZoneListCommand;

    public GetAllSafeZoneCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllSafeZoneListCommand = CommandFactory.createGetAllSafeZoneListCommand(getHandler());
            _getAllSafeZoneListCommand.execute();
            _safeZone = _getAllSafeZoneListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<SafeZone> getReturnParam() {
        return _safeZone;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
