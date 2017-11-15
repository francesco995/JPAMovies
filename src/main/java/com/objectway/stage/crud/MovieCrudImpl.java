package com.objectway.stage.crud;

import com.objectway.stage.EntityManagerUtil;
import com.objectway.stage.model.Movie;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MovieCrudImpl implements MovieCrud {

    public List<Movie> findAllMovies() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Query query = em.createNamedQuery(Movie.FIND_ALL);
        return query.getResultList();

    }

    public Movie saveMovie(Movie movie) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();

        return movie;
    }

    public Movie updateMovie(Movie movie) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(movie);
        em.getTransaction().commit();

        return movie;
    }

    public Movie findMovieById(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        return em.find(Movie.class, id);
    }
}
