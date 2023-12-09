package com.ucab.cmcapp.logic.commands.history.atomic;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.victim.atomic.AddVictimCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.HistoryDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddHistoryCommand extends Command<History> {

    private static Logger _logger = LoggerFactory.getLogger(AddHistoryCommand.class);
    private History _history;
    private HistoryDao _dao;

    public AddHistoryCommand(History history, DBHandler handler) {
        setHandler(handler);
        _history = history;
        _dao = DaoFactory.createHistoryDao(getHandler());
    }

    public AddHistoryCommand(History history) {
        _history = history;
        setHandler(new DBHandler());
        _dao = DaoFactory.createHistoryDao(getHandler());
    }

    @Override
    public void execute() {
        _history = _dao.insert(_history);
    }

    @Override
    public History getReturnParam() {
        return _history;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
