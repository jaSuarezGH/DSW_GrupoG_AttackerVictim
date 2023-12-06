package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.SafeZone;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class SafeZoneDao extends BaseDao<SafeZone> {

    private static Logger _logger = LoggerFactory.getLogger(SafeZoneDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public SafeZoneDao() {
        super();
    }

    public SafeZoneDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
