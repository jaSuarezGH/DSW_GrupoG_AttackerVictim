package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

    /**
     * Este metodo consulta en DB una victima segun su estructura de usuario
     *
     * @param userId estructura de User asociada
     * @return Victim o null o CupraException
     */
    public Victim getVictimByUserId(User userId) {
        Victim result;
        try {
            CriteriaQuery<Victim> query = _builder.createQuery(Victim.class);
            Root<Victim> root = query.from(Victim.class);

            query.select(root);
            query.where(_builder.equal(root.get("_user"), userId));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

}
