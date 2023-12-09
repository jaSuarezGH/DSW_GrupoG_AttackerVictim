package com.ucab.cmcapp.logic.commands.history.atomic;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.HistoryDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;

public class EraseHistoryCommand extends Command<History> {

    private History _history;
    private HistoryDao _dao;

    public EraseHistoryCommand(History history, DBHandler handler) {
        setHandler(handler);
        _history = history;
        _dao = DaoFactory.createHistoryDao(getHandler());
    }

    @Override
    public void execute() {
        _history = _dao.delete(_history);
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
