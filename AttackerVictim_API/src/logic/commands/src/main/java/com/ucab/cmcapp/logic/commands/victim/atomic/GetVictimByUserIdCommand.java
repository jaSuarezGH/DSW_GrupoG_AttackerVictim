package com.ucab.cmcapp.logic.commands.victim.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;

public class GetVictimByUserIdCommand extends Command<Victim> {

    private Victim _victim;
    private VictimDao _dao;

    public GetVictimByUserIdCommand(Victim victim) {
        _victim = victim;
        setHandler(new DBHandler());
        _dao = DaoFactory.createVictimDao(getHandler());
    }

    @Override
    public void execute() {
        _victim = _dao.getVictimByUserId(_victim.get_user_id());
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
