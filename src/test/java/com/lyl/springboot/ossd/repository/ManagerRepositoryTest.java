package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerRepositoryTest {
    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void testModifyPwdById(){

        Manager manager = new Manager("1213","123", 0);

        managerRepository.save(manager);

        if(managerRepository.modifyPwdById("2345","1213") == 1){
            System.out.println("test is sucessful!");
        }else{
            System.out.println("test is faild");
        }
    }
}
