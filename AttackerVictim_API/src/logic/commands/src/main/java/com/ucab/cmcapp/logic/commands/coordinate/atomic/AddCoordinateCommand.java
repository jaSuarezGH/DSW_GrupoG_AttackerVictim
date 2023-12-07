package com.ucab.cmcapp.logic.commands.coordinate.atomic;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.history.atomic.AddHistoryCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordinateDao;
import com.ucab.cmcapp.persistence.dao.HistoryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddCoordinateCommand extends Command<Coordinate> {

    private static Logger _logger = LoggerFactory.getLogger(AddCoordinateCommand.class);
    private Coordinate _coordinate;
    private CoordinateDao _dao;

    public AddCoordinateCommand(Coordinate coordinate, DBHandler handler) {
        setHandler(handler);
        _coordinate = coordinate;
        _dao = DaoFactory.createCoordinateDao(getHandler());
    }

    public AddCoordinateCommand(Coordinate coordinate) {
        _coordinate = coordinate;
        setHandler(new DBHandler());
        _dao = DaoFactory.createCoordinateDao(getHandler());
    }

    @Override
    public void execute() {
        _coordinate = _dao.insert(_coordinate);
    }

    @Override
    public Coordinate getReturnParam() {
        return _coordinate;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
