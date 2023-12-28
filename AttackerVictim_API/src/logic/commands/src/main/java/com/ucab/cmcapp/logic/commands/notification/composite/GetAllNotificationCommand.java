package com.ucab.cmcapp.logic.commands.notification.composite;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.atomic.GetAllIncidentListCommand;
import com.ucab.cmcapp.logic.commands.notification.atomic.GetAllNotificationListCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllNotificationCommand extends Command<Notification> {

    private List<Notification> _notification;
    private GetAllNotificationListCommand _getAllNotificationListCommand;

    public GetAllNotificationCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllNotificationListCommand = CommandFactory.createGetAllNotificationListCommand(getHandler());
            _getAllNotificationListCommand.execute();
            _notification = _getAllNotificationListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<Notification> getReturnParam() {
        return _notification;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
