package com.ucab.cmcapp.logic.commands.notification.atomic;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.Incident.atomic.AddIncidentCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.IncidentDao;
import com.ucab.cmcapp.persistence.dao.NotificationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddNotificationCommand extends Command<Notification> {

    private static Logger _logger = LoggerFactory.getLogger(AddNotificationCommand.class);
    private Notification _notification;
    private NotificationDao _dao;

    public AddNotificationCommand(Notification notification, DBHandler handler) {
        setHandler(handler);
        _notification = notification;
        _dao = DaoFactory.createNotificationDao(getHandler());
    }

    public AddNotificationCommand(Notification notification) {
        _notification = notification;
        setHandler(new DBHandler());
        _dao = DaoFactory.createNotificationDao(getHandler());
    }

    @Override
    public void execute() {
        _notification = _dao.insert(_notification);
    }

    @Override
    public Notification getReturnParam() {
        return _notification;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
