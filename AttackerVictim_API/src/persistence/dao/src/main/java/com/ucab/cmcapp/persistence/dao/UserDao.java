package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class UserDao extends BaseDao<User> {
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public UserDao() {
        super();
    }

    public UserDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Este metodo consulta en DB un usuario por email
     *
     * @param email email a consultar
     * @return User o null o CupraException
     */
    public User getUserByEmail(String email) {
        User result = EntityFactory.createUser();
        try {
            CriteriaQuery<User> query = _builder.createQuery(User.class);
            Root<User> root = query.from(User.class);

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
     * Este metodo consulta en DB un usuario por username
     *
     * @param username username a consultar
     * @return User o null o CupraException
     */
    public User getUserByUsername(String username) {
        User result = EntityFactory.createUser();
        try {
            CriteriaQuery<User> query = _builder.createQuery(User.class);
            Root<User> root = query.from(User.class);

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

    /**
     * Este metodo consulta en DB un usuario por cedula
     *
     * @param personal_id cedula de usuario
     * @return User o null o CupraException
     */
    public User getUserByPersonalId(String personal_id) {
        User result = EntityFactory.createUser();
        try {
            CriteriaQuery<User> query = _builder.createQuery(User.class);
            Root<User> root = query.from(User.class);

            query.select(root);
            query.where(_builder.equal(root.get("_personal_id"), personal_id));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

    /**
     * Este metodo consulta en DB un usuario por MAC
     *
     * @param mac_address direccion MAC de usuario
     * @return User o null o CupraException
     */
    public User getUserByMacAddress(String mac_address) {
        User result = EntityFactory.createUser();
        try {
            CriteriaQuery<User> query = _builder.createQuery(User.class);
            Root<User> root = query.from(User.class);

            query.select(root);
            query.where(_builder.equal(root.get("_mac_address"), mac_address));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

}
