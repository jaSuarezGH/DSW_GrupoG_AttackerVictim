package com.ucab.cmcapp.logic.commands.attacker.composite;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.attacker.atomic.EraseAttackerCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.EraseVictimCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteAttackerCommand extends Command<Attacker> {

    private Attacker _attacker;
    private Attacker _result;
    private EraseAttackerCommand _eraseAttackerCommand;

    public DeleteAttackerCommand(Attacker attacker) {
        _attacker = attacker;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseAttackerCommand = CommandFactory.createEraseAttackerCommand(_attacker, getHandler());
            _eraseAttackerCommand.execute();
            _result = _eraseAttackerCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Attacker getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
