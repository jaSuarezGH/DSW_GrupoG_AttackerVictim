package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Coordinate;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class CoordinateDao extends BaseDao<Coordinate> {

    private static Logger _logger = LoggerFactory.getLogger(CoordinateDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public CoordinateDao() {
        super();
    }

    public CoordinateDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
