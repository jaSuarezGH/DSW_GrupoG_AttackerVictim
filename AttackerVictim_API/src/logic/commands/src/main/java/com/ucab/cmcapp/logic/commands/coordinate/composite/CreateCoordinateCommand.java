package com.ucab.cmcapp.logic.commands.coordinate.composite;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordinate.atomic.AddCoordinateCommand;
import com.ucab.cmcapp.logic.commands.history.atomic.AddHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.composite.CreateHistoryCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateCoordinateCommand extends Command<Coordinate> {

    private static Logger _logger = LoggerFactory.getLogger(CreateCoordinateCommand.class);
    private Coordinate _coordinate;
    private Coordinate _result;
    private AddCoordinateCommand _addCoordinateCommand;

    public CreateCoordinateCommand(Coordinate coordinate) {
        _coordinate = coordinate;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _addCoordinateCommand = CommandFactory.createAddCoordinateCommand(_coordinate, getHandler());
            _addCoordinateCommand.execute();
            _result = _addCoordinateCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Coordinate getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
