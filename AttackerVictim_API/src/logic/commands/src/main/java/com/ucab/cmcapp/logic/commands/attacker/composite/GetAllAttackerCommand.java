package com.ucab.cmcapp.logic.commands.attacker.composite;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.attacker.atomic.GetAllAttackerListCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.GetAllVictimListCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllAttackerCommand extends Command<Attacker> {

    private List<Attacker> _attacker;
    private GetAllAttackerListCommand _getAllAttackerListCommand;

    public GetAllAttackerCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllAttackerListCommand = CommandFactory.createGetAllAttackerListCommand(getHandler());
            _getAllAttackerListCommand.execute();
            _attacker = _getAllAttackerListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<Attacker> getReturnParam() {
        return _attacker;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
