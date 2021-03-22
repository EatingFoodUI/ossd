package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.Manager;

public interface ManagerService {

    void save(Manager manager);

    void deleteById(String id);

    Manager findByManagerId(String managerId);

    int modifyPwdById(String managerPwd,String managerId);

}
