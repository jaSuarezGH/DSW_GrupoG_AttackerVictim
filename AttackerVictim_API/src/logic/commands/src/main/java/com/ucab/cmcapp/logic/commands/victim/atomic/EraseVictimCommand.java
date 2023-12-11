package com.ucab.cmcapp.logic.commands.victim.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;

public class EraseVictimCommand extends Command<Victim> {

    private Victim _victim;
    private VictimDao _dao;

    public EraseVictimCommand(Victim victim, DBHandler handler) {
        setHandler(handler);
        _victim = victim;
        _dao = DaoFactory.createVictimDao(getHandler());
    }

    @Override
    public void execute() {
        _victim = _dao.delete(_victim);
    }

    @Override
    public Victim getReturnParam() {
        return _victim;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
