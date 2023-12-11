package com.ucab.cmcapp.logic.commands.victim.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;

import java.util.List;

public class GetAllVictimListCommand extends Command<Victim> {

    private List<Victim> _result;
    private VictimDao _dao;

    public GetAllVictimListCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createVictimDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(Victim.class);
    }

    @Override
    public List<Victim> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
