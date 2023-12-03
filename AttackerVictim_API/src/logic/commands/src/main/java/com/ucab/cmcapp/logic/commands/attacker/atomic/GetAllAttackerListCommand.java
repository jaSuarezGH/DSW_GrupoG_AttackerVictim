package com.ucab.cmcapp.logic.commands.attacker.atomic;

import com.ucab.cmcapp.common.entities.Attacker;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AttackerDao;
import com.ucab.cmcapp.persistence.dao.VictimDao;

import java.util.List;

public class GetAllAttackerListCommand extends Command<Attacker> {

    private List<Attacker> _result;
    private AttackerDao _dao;

    public GetAllAttackerListCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createAttackerDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(Attacker.class);
    }

    @Override
    public List<Attacker> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
