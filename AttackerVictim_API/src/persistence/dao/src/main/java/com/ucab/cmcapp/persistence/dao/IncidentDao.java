package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Incident;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class IncidentDao extends BaseDao<Incident> {

    private static Logger _logger = LoggerFactory.getLogger(IncidentDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public IncidentDao() {
        super();
    }

    public IncidentDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
