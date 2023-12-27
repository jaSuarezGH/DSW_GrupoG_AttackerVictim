package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class NotificationDao extends BaseDao<Notification> {

    private static Logger _logger = LoggerFactory.getLogger(NotificationDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public NotificationDao() {
        super();
    }

    public NotificationDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
