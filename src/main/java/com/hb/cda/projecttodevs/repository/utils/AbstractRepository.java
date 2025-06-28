package com.hb.cda.projecttodevs.repository.utils;

import com.hb.cda.projecttodevs.repository.Database;
import com.hb.cda.projecttodevs.repository.interfaces.GenericRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<E, K> implements GenericRepository<E, K> {
    private final Class<E> entityClass;
    protected final EntityManager em;

    /**
     * @param em          un EntityManager déjà ouvert dans le Main (pas fermé ici)
     * @param entityClass la classe de l’entité gérée
     */
    protected AbstractRepository(EntityManager em, Class<E> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public List<E> findAll() {
        try {
            return em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
        } catch (Exception ex) {
            System.err.println("findAll: " + ex.getMessage());
            return Collections.emptyList();
        }
    }

    public Optional<E> findById(K id) {
        try {
            E instance = em.find(entityClass, id);
            if (instance != null) {
                return Optional.of(instance);
            }
            return Optional.empty();
        } catch (Exception ex) {
            System.err.println("findById: " + ex.getMessage());
            return Optional.empty();
        }

        // Ou bien en une seule ligne avec le ofNullable
        // return Optional.ofNullable(em.find(E.class, id));
    }

    public boolean persist(E entity) {
        try {
            em.persist(entity);
            return true;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("persist: " + ex.getMessage());
            return false;
        }
    }


    public boolean update(E entity) {
        try  {
            em.merge(entity);
            return true;
        } catch (Exception ex) {
            if (em.getTransaction().isActive())  em.getTransaction().rollback();
            System.err.println("update: " + ex.getMessage());
            return false;
        }
    }

    public boolean delete(E entity) {
        try {
            E managed = em.merge(entity);
            em.remove(managed);
            return true;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("delete: " + ex.getMessage());
            return false;
        }
    }

}
