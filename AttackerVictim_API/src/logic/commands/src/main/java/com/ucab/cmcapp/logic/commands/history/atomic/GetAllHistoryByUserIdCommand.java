package com.ucab.cmcapp.logic.commands.history.atomic;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.HistoryDao;
import com.ucab.cmcapp.persistence.dao.IncidentDao;

import java.util.List;

public class GetAllHistoryByUserIdCommand extends Command<History> {

    private History _history;
    private List<History> _result;
    private HistoryDao _dao;

    public GetAllHistoryByUserIdCommand(History history) {
        _history = history;
        setHandler(new DBHandler());
        _dao = DaoFactory.createHistoryDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.getAllHitoryByUserId(_history.get_user());
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
