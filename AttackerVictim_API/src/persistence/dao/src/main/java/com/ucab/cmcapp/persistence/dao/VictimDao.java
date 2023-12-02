package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class VictimDao extends BaseDao<Victim>{
    private static Logger _logger = LoggerFactory.getLogger(VictimDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public VictimDao() {
        super();
    }

    public VictimDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }
}
