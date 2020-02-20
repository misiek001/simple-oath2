package com.mbor.service;

import com.mbor.domain.security.Privilege;

public interface IPrivilegeService {

    Privilege findByName(String name);
}
