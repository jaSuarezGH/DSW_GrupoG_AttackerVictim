package com.ucab.cmcapp.logic.commands.history.composite;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.history.atomic.EraseHistoryCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.EraseVictimCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteHistoryCommand extends Command<History> {

    private History _history;
    private History _result;
    private EraseHistoryCommand _eraseHistoryCommand;

    public DeleteHistoryCommand(History history) {
        _history = history;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseHistoryCommand = CommandFactory.createEraseHistoryCommand(_history, getHandler());
            _eraseHistoryCommand.execute();
            _result = _eraseHistoryCommand.getReturnParam();
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
