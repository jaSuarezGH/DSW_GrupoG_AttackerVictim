package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

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

}
