package com.ucab.cmcapp.logic.commands.history.composite;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.history.atomic.GetAllHistoryListCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.GetAllVictimListCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllHistoryCommand extends Command<History> {

    private List<History> _history;
    private GetAllHistoryListCommand _getAllHistoryListCommand;

    public GetAllHistoryCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllHistoryListCommand = CommandFactory.createGetAllHistoryListCommand(getHandler());
            _getAllHistoryListCommand.execute();
            _history = _getAllHistoryListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<History> getReturnParam() {
        return _history;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
