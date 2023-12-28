package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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

    public List<Notification> getAllNotificationByUserId(User userId) {
        List<Notification> results;
        try {
            CriteriaQuery<Notification> query = _builder.createQuery(Notification.class);
            Root<Notification> root = query.from(Notification.class);

            query.select(root);
            query.where(_builder.equal(root.get("_user"), userId));

            results = _em.createQuery(query).getResultList();

            if (results.isEmpty()) // Retornar null en lugar de []
                return null;

        } catch (NoResultException e) {
            //return Collections.emptyList();  // En caso de que quieras retornar []
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return results;
    }

}
