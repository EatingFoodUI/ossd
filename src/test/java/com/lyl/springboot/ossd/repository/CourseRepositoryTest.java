package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findByCourseIdTest(){
        Date date = new Date();
        Course course = new Course("123", "ert", "123", "123", 12, "courseIndex", "preStudy", "courseBook", "teacherId", date, 12, 12,"0");
        courseRepository.save(course);

        if(courseRepository.findByCourseId("123").getCourseName().equals("ert")){
            System.out.println("test is successful!");
        }else{
            System.out.println("test is failed");
        }
    }

    @Test
    public void testModifyCoursePreStudyById(){

        Date date = new Date();
        Course course = new Course("123", "ert", "123", "123", 12, "courseIndex", "preStudy", "courseBook", "teacherId", date, 12, 12,"0");
        courseRepository.save(course);

        if(courseRepository.modifyCoursePreStudyById("12345","123")==1){
            System.out.println("test is sucessful!");
        }else{
            System.out.println("test is faild");
        }
    }
}
