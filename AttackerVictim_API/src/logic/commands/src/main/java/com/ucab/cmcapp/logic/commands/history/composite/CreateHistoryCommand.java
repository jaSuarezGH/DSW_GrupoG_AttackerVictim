package com.ucab.cmcapp.logic.commands.history.composite;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.history.atomic.AddHistoryCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.AddVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.CreateVictimCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateHistoryCommand extends Command<History> {
    private History _history;
    private History _result;
    private AddHistoryCommand _addVictimCommand;

    public CreateHistoryCommand(History history) {
        _history = history;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _addVictimCommand = CommandFactory.createAddHistoryCommand(_history, getHandler());
            _addVictimCommand.execute();
            _result = _addVictimCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public History getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
