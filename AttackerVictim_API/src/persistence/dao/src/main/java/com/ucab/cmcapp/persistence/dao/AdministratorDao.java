package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class AdministratorDao extends BaseDao<Administrator> {

    private static Logger _logger = LoggerFactory.getLogger(AdministratorDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public AdministratorDao() {
        super();
    }

    public AdministratorDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
