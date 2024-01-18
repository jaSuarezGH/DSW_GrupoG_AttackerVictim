package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Administrator;
import com.ucab.cmcapp.common.entities.History;
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

    /**
     * Este metodo consulta en base de datos un administrador segun email
     *
     * @param email email de administrador a consultar
     * @return Administrator o CupraException
     */
    public Administrator getAdministratorByEmail(String email) {
        Administrator result = EntityFactory.createAdministrator();
        try {
            CriteriaQuery<Administrator> query = _builder.createQuery(Administrator.class);
            Root<Administrator> root = query.from(Administrator.class);

            query.select(root);
            query.where(_builder.equal(root.get("_email"), email));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

    /**
     * Este metodo consulta en base de datos un administrador segun username
     *
     * @param username username de administrador a consultar
     * @return Administrator o null o CupraException
     */
    public Administrator getAdministratorByUsername(String username) {
        Administrator result = EntityFactory.createAdministrator();
        try {
            CriteriaQuery<Administrator> query = _builder.createQuery(Administrator.class);
            Root<Administrator> root = query.from(Administrator.class);

            query.select(root);
            query.where(_builder.equal(root.get("_username"), username));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

}
