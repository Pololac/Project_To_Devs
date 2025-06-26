package com.hb.cda.projecttodevs.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<E, K> {
    List<E> findAll();
    Optional<E> findById(K id);
    boolean persist(E entity);
    boolean update(E entity);
    boolean delete(E entity);
}

