package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.AccountPit;
import com.lyl.springboot.ossd.repository.AccountPitRepository;
import com.lyl.springboot.ossd.service.AccountPitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountPitServiceImpl implements AccountPitService {

    @Autowired
    private AccountPitRepository accountPitRepository;


    @Override
    public AccountPit findByAccount(String account) {
        return accountPitRepository.findByAccount(account);
    }

    @Override
    public int modifyPitAddrByAccount(String pitAddr, String account) {
        return accountPitRepository.modifyPitAddrByAccount(pitAddr, account);
    }

    @Override
    public void save(AccountPit accountPit) {
        accountPitRepository.save(accountPit);
    }
}
