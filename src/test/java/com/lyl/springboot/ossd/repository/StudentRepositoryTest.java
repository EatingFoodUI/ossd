package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testSave() throws Exception{

        Student student = new Student("1213","lyl","12345","44132","ess");
        studentRepository.save(student);

        Student student1 =  studentRepository.findByStudentId("1213");

        if(student.getStudentId().equals(student1.getStudentId())){
            System.out.println("test is sucessful!");
        }else{
            System.out.println("test is faild");
        }
    }

    @Test
    public void testModifyPwdById(){

        Student student = new Student("1215","lyll","123456","441326","ess");
        studentRepository.save(student);

        if(studentRepository.modifyPwdById("2345","1215") == 1){
            System.out.println("test is sucessful!");
        }else{
            System.out.println("test is faild");
        }
    }
}
