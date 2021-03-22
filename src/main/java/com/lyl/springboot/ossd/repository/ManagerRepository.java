package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String> {
    Manager findByManagerId(String ManagerId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Manager set managerPwd =?1 where managerId=?2")
    int modifyPwdById(String ManagerPwd,String ManagerId);
}
