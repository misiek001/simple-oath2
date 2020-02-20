package com.mbor.dao;

import com.mbor.domain.security.Privilege;
import com.mbor.domain.security.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Repository
public class PrivilegeDao extends RawDao<Privilege> implements IPrivilegeDao {

    public PrivilegeDao() {
        this.clazz = Privilege.class;
    }

    @Override
    public Optional<Privilege> findByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Privilege> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<Privilege> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        TypedQuery<Privilege> allQuery = entityManager.createQuery(criteriaQuery);
        return Optional.ofNullable(allQuery.getSingleResult());
    }
}
