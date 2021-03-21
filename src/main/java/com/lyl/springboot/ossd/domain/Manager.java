package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    @Column(nullable = false, unique = true)
    private String managerId;

    @Column(nullable = false, unique = false)
    private String managerPwd;

    public Manager(){

    }

    public Manager(String managerId, String managerPwd) {
        this.managerId = managerId;
        this.managerPwd = managerPwd;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerPwd() {
        return managerPwd;
    }

    public void setManagerPwd(String managerPwd) {
        this.managerPwd = managerPwd;
    }
}
