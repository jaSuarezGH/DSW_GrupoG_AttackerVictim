package com.ucab.cmcapp.logic.commands.attacker.atomic;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AttackerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddAttackerCommand extends Command<Attacker> {

    private Attacker _attacker;
    private AttackerDao _dao;

    public AddAttackerCommand(Attacker attacker, DBHandler handler) {
        setHandler(handler);
        _attacker = attacker;
        _dao = DaoFactory.createAttackerDao(getHandler());
    }

    public AddAttackerCommand(Attacker attacker) {
        _attacker = attacker;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAttackerDao(getHandler());
    }

    @Override
    public void execute() {
        _attacker = _dao.insert(_attacker);
    }

    @Override
    public Attacker getReturnParam() {
        return _attacker;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
