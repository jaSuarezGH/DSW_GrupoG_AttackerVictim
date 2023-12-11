package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.History;
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
import java.util.Collections;
import java.util.List;

public class HistoryDao extends BaseDao<History> {

    private static Logger _logger = LoggerFactory.getLogger(HistoryDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public HistoryDao() {
        super();
    }

    public HistoryDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<History> getAllHitoryByUserId(User userId) {
        List<History> results;
        try {
            CriteriaQuery<History> query = _builder.createQuery(History.class);
            Root<History> root = query.from(History.class);

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
