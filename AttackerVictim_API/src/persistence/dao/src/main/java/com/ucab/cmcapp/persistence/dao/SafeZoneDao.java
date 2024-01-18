package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.SafeZone;
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
import java.util.List;

public class SafeZoneDao extends BaseDao<SafeZone> {
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

    /**
     * Este metodo consulta en DB todas las zonas seguras de un usuario
     *
     * @param userId estructura de User asociada
     * @return lista de SafeZone o null o CupraException
     */
    public List<SafeZone> getAllSafeZoneByUserId(User userId) {
        List<SafeZone> results;
        try {
            CriteriaQuery<SafeZone> query = _builder.createQuery(SafeZone.class);
            Root<SafeZone> root = query.from(SafeZone.class);

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
