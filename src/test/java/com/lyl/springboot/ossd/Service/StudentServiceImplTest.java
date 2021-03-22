package com.lyl.springboot.ossd.Service;

import com.lyl.springboot.ossd.domain.Student;
import com.lyl.springboot.ossd.service.ServiceImplement.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    private StudentServiceImpl studentService;

    @Test
    public void testFindByStudentTel(){
        Student student = new Student("1235","lili","123450","1234567890","1234567890");
        if(studentService.findByStudentId("1235") != null){
            studentService.deleteById("1235");
        }
        studentService.save(student);
        Student student1 = studentService.findByStudentTel("123450");
        if(student.getStudentName().equals(student1.getStudentName())){
            System.out.println("test is successful!");
        }else{
            System.out.println("test is failed!");
        }
    }


}
