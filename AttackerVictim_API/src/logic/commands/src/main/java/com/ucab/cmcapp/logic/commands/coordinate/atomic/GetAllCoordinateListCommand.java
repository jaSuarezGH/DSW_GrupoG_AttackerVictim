package com.ucab.cmcapp.logic.commands.coordinate.atomic;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordinateDao;
import com.ucab.cmcapp.persistence.dao.HistoryDao;

import java.util.List;

public class GetAllCoordinateListCommand extends Command<Command> {

    private List<Coordinate> _result;
    private CoordinateDao _dao;

    public GetAllCoordinateListCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createCoordinateDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(Coordinate.class);
    }

    @Override
    public List<Coordinate> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
