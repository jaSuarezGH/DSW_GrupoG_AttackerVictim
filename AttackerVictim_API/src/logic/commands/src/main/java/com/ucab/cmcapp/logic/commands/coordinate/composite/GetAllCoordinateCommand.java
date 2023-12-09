package com.ucab.cmcapp.logic.commands.coordinate.composite;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordinate.atomic.GetAllCoordinateListCommand;
import com.ucab.cmcapp.logic.commands.history.atomic.GetAllHistoryListCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllCoordinateCommand extends Command<Coordinate> {

    private List<Coordinate> _coordinate;
    private GetAllCoordinateListCommand _getAllCoordinateListCommand;

    public GetAllCoordinateCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllCoordinateListCommand = CommandFactory.createGetAllCoordinateListCommand(getHandler());
            _getAllCoordinateListCommand.execute();
            _coordinate = _getAllCoordinateListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<Coordinate> getReturnParam() {
        return _coordinate;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
