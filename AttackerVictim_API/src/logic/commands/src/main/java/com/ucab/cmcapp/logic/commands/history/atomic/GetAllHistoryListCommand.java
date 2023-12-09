package com.ucab.cmcapp.logic.commands.history.atomic;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.HistoryDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;

import java.util.List;

public class GetAllHistoryListCommand extends Command<History> {

    private List<History> _result;
    private HistoryDao _dao;

    public GetAllHistoryListCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createHistoryDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(History.class);
    }

    @Override
    public List<History> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }


}
