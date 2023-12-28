package com.ucab.cmcapp.logic.commands.notification.atomic;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.HistoryDao;
import com.ucab.cmcapp.persistence.dao.NotificationDao;

import java.util.List;

public class GetAllNotificationByUserIdCommand extends Command<Notification> {

    private Notification _notification;
    private List<Notification> _result;
    private NotificationDao _dao;

    public GetAllNotificationByUserIdCommand(Notification notification) {
        _notification = notification;
        setHandler(new DBHandler());
        _dao = DaoFactory.createNotificationDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.getAllNotificationByUserId(_notification.get_user());
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
