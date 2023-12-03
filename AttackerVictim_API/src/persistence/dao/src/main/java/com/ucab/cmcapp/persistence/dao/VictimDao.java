package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Victim;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
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

    public Boolean deleteVictimByUserId(String userId){
        try{
            CriteriaDelete<Victim> criteriaDelete = _builder.createCriteriaDelete(Victim.class);
            Root<Victim> root = criteriaDelete.from(Victim.class);
            criteriaDelete.where(_builder.equal(root.get("_user_id"), userId));
            _em.getTransaction().begin();
            int rowsDeleted = _em.createQuery(criteriaDelete).executeUpdate();
            _em.getTransaction().commit();
            _em.close();
            return (rowsDeleted > 0);
        }catch (Exception e){
            System.out.println("ERROR deleteVictimByUserId");
        }
        return false;
    }
}
