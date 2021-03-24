package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountPit {
    @Id
    @Column(nullable = false, unique = true)
    private String account;

    @Column(nullable = true, unique = true)
    private String pitAddr;

    @Column(nullable = false, unique = false)
    private String who;

    public AccountPit(String account, String pitAddr, String who) {
        this.account = account;
        this.pitAddr = pitAddr;
        this.who = who;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPitAddr() {
        return pitAddr;
    }

    public void setPitAddr(String pitAddr) {
        this.pitAddr = pitAddr;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
