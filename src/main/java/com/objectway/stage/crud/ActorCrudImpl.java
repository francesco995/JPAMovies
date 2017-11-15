package com.objectway.stage.crud;

import com.objectway.stage.EntityManagerUtil;
import com.objectway.stage.model.Actor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ActorCrudImpl implements ActorCrud {

    public List<Actor> findAllActors() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Query query = em.createNamedQuery(Actor.FIND_ALL);
        return query.getResultList();

    }

    public Actor saveActor(Actor actor) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(actor);
        em.getTransaction().commit();

        return actor;
    }

    public Actor updateActor(Actor actor) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(actor);
        em.getTransaction().commit();

        return actor;
    }

    public Actor findActorById(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        return em.find(Actor.class, id);
    }
}
