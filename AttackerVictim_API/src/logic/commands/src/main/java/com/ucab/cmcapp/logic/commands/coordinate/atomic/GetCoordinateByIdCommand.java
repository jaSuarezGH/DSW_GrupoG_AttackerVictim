package com.ucab.cmcapp.logic.commands.coordinate.atomic;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordinateDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetCoordinateByIdCommand extends Command<Coordinate> {

    private long _coordinateId;
    private Coordinate _result;
    private CoordinateDao _dao;

    public GetCoordinateByIdCommand(DBHandler handler, long coordinateId) {
        _coordinateId = coordinateId;
        setHandler(handler);
        _dao = DaoFactory.createCoordinateDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.find(_coordinateId, Coordinate.class);
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
