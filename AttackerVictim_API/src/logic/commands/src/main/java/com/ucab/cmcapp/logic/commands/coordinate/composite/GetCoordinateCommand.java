package com.ucab.cmcapp.logic.commands.coordinate.composite;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordinate.atomic.GetCoordinateByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetCoordinateCommand extends Command<Coordinate> {

    private Coordinate _coordinate;
    long _id;
    private GetCoordinateByIdCommand _getCoordinateByIdCommand;

    public GetCoordinateCommand(Coordinate coordinate) {
        _id = coordinate.get_id();
        _coordinate = coordinate;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getCoordinateByIdCommand = CommandFactory.createGetCoordinateByIdCommand(getHandler(), _id);
            _getCoordinateByIdCommand.execute();
            _coordinate = _getCoordinateByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
