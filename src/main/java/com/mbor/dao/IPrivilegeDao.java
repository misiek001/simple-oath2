package com.mbor.dao;

import com.mbor.domain.security.Privilege;

import java.util.Optional;

public interface IPrivilegeDao extends IDao<Privilege> {

    Optional<Privilege> findByName(String name);

}
