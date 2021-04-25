package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.AccountPit;

public interface AccountPitService {
    AccountPit findByAccount(String account);

    // 通过id和状态status获取
    AccountPit findByAccountAndWho(String AccountId, String Status);

    int modifyPitAddrByAccount(String pitAddr, String account);

    void save(AccountPit accountPit);
}
