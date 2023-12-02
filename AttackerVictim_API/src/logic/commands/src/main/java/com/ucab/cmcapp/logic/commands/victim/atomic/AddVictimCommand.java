package com.ucab.cmcapp.logic.commands.victim.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddVictimCommand extends Command<Victim> {

    private static Logger _logger = LoggerFactory.getLogger(AddVictimCommand.class);
    private Victim _victim;
    private VictimDao _dao;

    public AddVictimCommand(Victim victim, DBHandler handler) {
        setHandler(handler);
        _victim = victim;
        _dao = DaoFactory.createVictimDao(getHandler());
    }

    public AddVictimCommand(Victim victim) {
        _victim = victim;
        setHandler(new DBHandler());
        _dao = DaoFactory.createVictimDao(getHandler());
    }

    @Override
    public void execute() {
        _victim = _dao.insert(_victim);
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
