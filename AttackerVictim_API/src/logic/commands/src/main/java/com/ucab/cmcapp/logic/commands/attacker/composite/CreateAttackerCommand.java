package com.ucab.cmcapp.logic.commands.attacker.composite;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.attacker.atomic.AddAttackerCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.AddVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.CreateVictimCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAttackerCommand extends Command<Attacker> {

    private static Logger _logger = LoggerFactory.getLogger(CreateAttackerCommand.class);
    private Attacker _attacker;
    private Attacker _result;
    private AddAttackerCommand _addAttackerCommand;

    public CreateAttackerCommand(Attacker attacker) {
        _attacker = attacker;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _addAttackerCommand = CommandFactory.createAddAttackerCommand(_attacker, getHandler());
            _addAttackerCommand.execute();
            _result = _addAttackerCommand.getReturnParam();
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
