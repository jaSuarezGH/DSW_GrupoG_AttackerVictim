package com.ucab.cmcapp.logic.commands.victim.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.GetAllUserListCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.GetAllVictimListCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllVictimCommand extends Command<Victim> {
    private List<Victim> _victim;
    private GetAllVictimListCommand _getAllVictimListCommand;

    public GetAllVictimCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllVictimListCommand = CommandFactory.createGetAllVictimListCommand(getHandler());
            _getAllVictimListCommand.execute();
            _victim = _getAllVictimListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<Victim> getReturnParam() {
        return _victim;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
