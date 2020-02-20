package com.mbor.service;

import com.mbor.dao.IPrivilegeDao;
import com.mbor.domain.security.Privilege;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrivilegeService implements IPrivilegeService {

    private final IPrivilegeDao privilegeDao;

    public PrivilegeService(IPrivilegeDao privilegeDao) {
        this.privilegeDao = privilegeDao;

    }

    @Override
    public Privilege findByName(String name) {
       return privilegeDao.findByName(name).orElseThrow(RuntimeException::new);
    }
}
