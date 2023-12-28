package com.ucab.cmcapp.logic.commands.notification.atomic;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.IncidentDao;
import com.ucab.cmcapp.persistence.dao.NotificationDao;

import java.util.List;

public class GetAllNotificationListCommand extends Command<Notification> {

    private List<Notification> _result;
    private NotificationDao _dao;

    public GetAllNotificationListCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createNotificationDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(Notification.class);
    }

    @Override
    public List<Notification> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
