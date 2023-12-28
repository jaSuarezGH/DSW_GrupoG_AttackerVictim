package com.ucab.cmcapp.logic.commands.notification.composite;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Incident.atomic.AddIncidentCommand;
import com.ucab.cmcapp.logic.commands.Incident.composite.CreateIncidentCommand;
import com.ucab.cmcapp.logic.commands.notification.atomic.AddNotificationCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateNotificationCommand extends Command<Notification> {

    private static Logger _logger = LoggerFactory.getLogger(CreateNotificationCommand.class);
    private Notification _notification;
    private Notification _result;
    private AddNotificationCommand _addNotificationCommand;

    public CreateNotificationCommand(Notification notification) {
        _notification = notification;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _addNotificationCommand = CommandFactory.createAddNotificationCommand(_notification, getHandler());
            _addNotificationCommand.execute();
            _result = _addNotificationCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Notification getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
