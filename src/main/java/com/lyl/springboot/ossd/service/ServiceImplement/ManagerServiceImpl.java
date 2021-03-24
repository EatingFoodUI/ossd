package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.Manager;
import com.lyl.springboot.ossd.repository.ManagerRepository;
import com.lyl.springboot.ossd.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public void save(Manager manager) {
        managerRepository.save(manager);
    }

    @Override
    public void deleteById(String id) {
        managerRepository.deleteById(id);
    }

    @Override
    public Manager findByManagerId(String managerId) {
        return managerRepository.findByManagerId(managerId);
    }

    @Override
    public Page<Manager> findByAuthentication(int authentication, Pageable pageable) {
        return managerRepository.findByAuthentication(authentication, pageable);
    }

    @Override
    public int modifyAuthenById(int authentication, String managerId) {
        return managerRepository.modifyAuthenById(authentication, managerId);
    }

    @Override
    public int modifyPwdById(String managerPwd, String managerId) {
        return managerRepository.modifyPwdById(managerPwd, managerId);
    }
}
