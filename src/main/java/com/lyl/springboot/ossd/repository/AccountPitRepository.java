package com.lyl.springboot.ossd.repository;


import com.lyl.springboot.ossd.domain.AccountPit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountPitRepository extends JpaRepository<AccountPit, String> {
    AccountPit findByAccount(String account);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE AccountPit set pitAddr=?1 where account=?2")
    int modifyPitAddrByAccount(String pitAddr,String account);
}
