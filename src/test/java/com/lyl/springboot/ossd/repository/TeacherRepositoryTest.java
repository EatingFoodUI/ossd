package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void testModifyPwdById(){

        Teacher teacher = new Teacher("1213","lyl","cqupt","123","ess@","12345","0");

        teacherRepository.save(teacher);

        if(teacherRepository.modifyPwdById("2345","1213") == 1){
            System.out.println("test is sucessful!");
        }else{
            System.out.println("test is faild");
        }
    }

    @Test
    public void testFindById(){
        if(teacherRepository.findByTeacherId("1213").getTeacherName().equals("lyl")){
            System.out.println("test is successful!");
        }else{
            System.out.println("test is failed");
        }
    }
}
