package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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

    /**
     * Este metodo consulta en DB un incidente segun el id de victima
     *
     * @param victimId id de victima
     * @return Incident o null o CupraException
     */
    public Incident getIncidentByVictimId(Victim victimId) {
        Incident result;
        try {
            CriteriaQuery<Incident> query = _builder.createQuery(Incident.class);
            Root<Incident> root = query.from(Incident.class);

            query.select(root);
            query.where(_builder.equal(root.get("_victim"), victimId));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

    /**
     * Este metodo consulta en DB un incidente segun el id de atacante
     *
     * @param attackerId id de atacante
     * @return Incident o null o CupraException
     */
    public Incident getIncidentByAttackerId(Attacker attackerId) {
        Incident result;
        try {
            CriteriaQuery<Incident> query = _builder.createQuery(Incident.class);
            Root<Incident> root = query.from(Incident.class);

            query.select(root);
            query.where(_builder.equal(root.get("_attacker"), attackerId));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

    /**
     * Este metodo consulta en DB las ultimas posiciones de una victima y atacante
     *
     * @param incidentId id del incidente asociado
     * @return Lista de History o null o CupraException
     */
    public List<History> getLastPositionsByIncidentId(Incident incidentId) {
        List<History> results;
        try {
            //CriteriaQuery<Incident> query = _builder.createQuery(Incident.class);
            //Root<Incident> root = query.from(Incident.class);

            String customSql = "(select * from history where (history.user IN (select attacker.user from attacker where attacker.id IN (select incident.attacker from incident where incident.id = " + incidentId.get_id() + "))) order by history.id desc limit 1)UNION(select * from history where (history.user IN (select victim.user from victim where victim.id IN (select incident.victim from incident where incident.id = " + incidentId.get_id() + "))) order by history.id desc limit 1)";
            Query query = _em.createNativeQuery(customSql, History.class);

            results = query.getResultList();

            if (results.size() < 2) // Retornar null en lugar de []
                return null;

        } catch (NoResultException e) {
            //return Collections.emptyList();  // En caso de que quieras retornar []
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return results;
    }

    /**
     * Este metodo consulta en DB la ultima posicion de un atacante
     *
     * @param incidentId id de incidente asociado
     * @return lista de History o CupraException
     */
    public History getAttackerLastPositionByIncidentId(Incident incidentId) {
        List<History> results;
        try {
            String customSql = "(select * from history where (history.user IN (select attacker.user from attacker where attacker.id IN (select incident.attacker from incident where incident.id = " + incidentId.get_id() + ")))order by history.id desc limit 1)";
            Query query = _em.createNativeQuery(customSql, History.class);

            results = query.getResultList();

            if (results.isEmpty()) // Retornar null en lugar de []
                return null;

        } catch (NoResultException e) {
            //return Collections.emptyList();  // En caso de que quieras retornar []
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return results.get(0);
    }

    /**
     * Este metodo consulta en DB la ultima posicion de una victima
     *
     * @param incidentId id de incidente asociado
     * @return lista de History o CupraException
     */
    public History getVictimLastPositionByIncidentId(Incident incidentId) {
        List<History> results;
        try {
            String customSql = "(select * from history where (history.user IN (select victim.user from victim where victim.id IN (select incident.victim from incident where incident.id = " + incidentId.get_id() + "))) order by history.id desc limit 1)";
            Query query = _em.createNativeQuery(customSql, History.class);

            results = query.getResultList();

            if (results.isEmpty()) // Retornar null en lugar de []
                return null;

        } catch (NoResultException e) {
            //return Collections.emptyList();  // En caso de que quieras retornar []
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return results.get(0);
    }

}
