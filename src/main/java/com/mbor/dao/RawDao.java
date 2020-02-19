package com.mbor.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class RawDao<T> {

    @PersistenceContext
    EntityManager entityManager;

    public Optional<T> save(T t) {
        entityManager.persist(t);
        return Optional.ofNullable(t);
    }


}
