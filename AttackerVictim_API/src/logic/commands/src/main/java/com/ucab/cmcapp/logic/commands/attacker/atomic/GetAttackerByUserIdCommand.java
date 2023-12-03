package com.ucab.cmcapp.logic.commands.attacker.atomic;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AttackerDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;

public class GetAttackerByUserIdCommand extends Command<Attacker> {

    private Attacker _attacker;
    private AttackerDao _dao;

    public GetAttackerByUserIdCommand(Attacker attacker) {
        _attacker = attacker;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAttackerDao(getHandler());
    }

    @Override
    public void execute() {
        _attacker = _dao.getAttackerByUserId(_attacker.get_user());
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
