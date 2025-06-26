package com.hb.cda.projecttodevs.repository.utils;

import com.hb.cda.projecttodevs.repository.Database;
import com.hb.cda.projecttodevs.repository.interfaces.GenericRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<E, K> implements GenericRepository<E, K> {
    private final Class<E> entityClass;

    public AbstractRepository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public List<E> findAll() {
        try {
            EntityManager em = Database.getManager();
            return em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
        } catch (PersistenceException e) {
            System.err.println(e);
        }
        return null;
    }

    public Optional<E> findById(K id) {
        try {
            EntityManager em = Database.getManager();
            E instance = em.find(entityClass, id);
            if (instance != null) {
                return Optional.of(instance);
            }
        } catch (PersistenceException e) {
            System.err.println(e);
        }
        return Optional.empty();

        // Ou bien en une seule ligne avec le ofNullable
        // return Optional.ofNullable(em.find(E.class, id));
    }

    public boolean persist(E entity) {
        try {
            EntityManager em = Database.getManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            System.err.println(e);
        }
        return false;
    }


    public boolean update(E entity) {
        try  {
            EntityManager em = Database.getManager();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            System.err.println(e);
        }
        return false;
    }

    public boolean delete(E entity) {
        try {
            EntityManager em = Database.getManager();
            em.getTransaction().begin();
            E merged = em.merge(entity);
            em.remove(merged);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            System.err.println(e);
        }
        return false;
    }

}
