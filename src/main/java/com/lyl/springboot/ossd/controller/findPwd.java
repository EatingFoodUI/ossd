package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.domain.Student;
import com.lyl.springboot.ossd.domain.Teacher;
import com.lyl.springboot.ossd.service.ServiceImplement.StudentServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/findPwd")
public class findPwd {
    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    TeacherServiceImpl teacherService;

    @RequestMapping(value = "/student1", method = RequestMethod.POST)
    public String findPwdStudent1(@RequestParam("Tel") String studentTel,
                                  @RequestParam("Email") String studentEmail){
        if(studentService.findByStudentEmail(studentEmail) == null){
            return "0";
        }else if(studentService.findByStudentTel(studentTel) == null){
            return "1";
        }
        return "2";
    }

    @RequestMapping(value = "/student2", method = RequestMethod.POST)
    public String findPwdStudent2(@RequestParam("Tel") String studentTel,
                                  @RequestParam("Email") String studentEmail,
                                  @RequestParam("Pwd") String studentPwd){
        Student student = studentService.findByStudentEmailAndStudentTel(studentEmail,studentTel);
        if(student == null){
            return "0";
        }
        studentService.modifyPwdById(studentPwd,student.getStudentId());
        return "1";
    }

    @RequestMapping(value = "/teacher1", method = RequestMethod.POST)
    public String findPwdTeacher1(@RequestParam("Tel") String TeacherTel,
                                  @RequestParam("Email") String TeacherEmail){
        if(teacherService.findByTeacherEmail(TeacherEmail) == null){
            return "0";
        }else if(teacherService.findByTeacherTel(TeacherTel) == null){
            return "1";
        }
        return "2";
    }

    @RequestMapping(value = "/teacher2", method = RequestMethod.POST)
    public String findPwdTeacher2(@RequestParam("Tel") String Tel,
                                  @RequestParam("Email") String Email,
                                  @RequestParam("Pwd") String Pwd){
        Teacher teacher = teacherService.findByTeacherEmailAndTeacherTel(Email,Tel);
        if(teacher == null){
            return "0";
        }
        teacherService.modifyPwdById(Pwd,teacher.getTeacherId());
        return "1";
    }
}
