package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.UserCourseRelation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CSRIDRepositoryTest {
    @Autowired
    private UserCourseRelationRepository userCourseRelationRepository;

    @Test
    public void SaveTest(){
        Date date = new Date();
        UserCourseRelation userCourseRelation = new UserCourseRelation(null,"123","123",date,1);
        userCourseRelationRepository.save(userCourseRelation);

        Pageable pageable = PageRequest.of(1,10, Sort.Direction.DESC, "courseUserId");
        // Page<UserCourseRelation> page = userCourseRelationRepository.findByCourseId("123", pageable);
        // System.out.println(page.getTotalElements());
        if(userCourseRelationRepository.findByCourseId("123", pageable).getTotalElements() > 0){
            System.out.println("test is successful");
        }else{
            System.out.println("test is failed");
        }
    }
}
