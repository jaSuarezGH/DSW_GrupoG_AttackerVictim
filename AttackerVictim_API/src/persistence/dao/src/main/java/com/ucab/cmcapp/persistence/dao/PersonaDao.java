package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactoryPersona;
import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PersonaDao extends BaseDao<Persona> {

    private EntityManager _em;
    private CriteriaBuilder _builder;

    public PersonaDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Persona getPersonaByName(String name) {
        Persona result = EntityFactoryPersona.createPersona();
        try {
            CriteriaQuery<Persona> query = _builder.createQuery(Persona.class);
            Root<Persona> root = query.from(Persona.class);

            query.select(root);
            query.where(_builder.equal(root.get("_name"), name));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            //logger stuff
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

}
