package com.ucab.cmcapp.logic.commands.victim.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.logic.commands.victim.atomic.EraseVictimCommand;

public class DeleteVictimCommand extends Command<Victim> {

    private Victim _victim;
    private Victim _result;
    private EraseVictimCommand _eraseVictimCommand;

    public DeleteVictimCommand(Victim victim) {
        _victim = victim;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseVictimCommand = CommandFactory.createEraseVictimCommand(_victim, getHandler());
            _eraseVictimCommand.execute();
            _result = _eraseVictimCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Victim getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
