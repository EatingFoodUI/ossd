package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManagerService {

    void save(Manager manager);

    void deleteById(String id);

    Manager findByManagerId(String managerId);

    Page<Manager> findByAuthentication(int authentication, Pageable pageable);

    int modifyAuthenById(int authentication,String managerId);

    int modifyPwdById(String managerPwd,String managerId);

}
