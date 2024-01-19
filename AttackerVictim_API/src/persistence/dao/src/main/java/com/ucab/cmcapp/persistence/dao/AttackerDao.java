package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Attacker;
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

public class AttackerDao extends BaseDao<Attacker>{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public AttackerDao() {
        super();
    }

    public AttackerDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Este metodo consulta en BD un atacante segun su usuario
     *
     * @param user estrucura User del atacante
     * @return Attacker o null o CupraException
     */
    public Attacker getAttackerByUserId(User user) {
        Attacker result;
        try {
            CriteriaQuery<Attacker> query = _builder.createQuery(Attacker.class);
            Root<Attacker> root = query.from(Attacker.class);

            query.select(root);
            query.where(_builder.equal(root.get("_user"), user));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

}
