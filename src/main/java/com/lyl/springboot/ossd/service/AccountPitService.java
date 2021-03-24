package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.AccountPit;

public interface AccountPitService {
    AccountPit findByAccount(String account);

    int modifyPitAddrByAccount(String pitAddr, String account);

}
