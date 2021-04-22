package com.lyl.springboot.ossd.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyl.springboot.ossd.domain.Student;
import com.lyl.springboot.ossd.domain.Teacher;
import com.lyl.springboot.ossd.service.ServiceImplement.ManagerServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.StudentServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.TeacherServiceImpl;
import com.lyl.springboot.ossd.utils.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class Register {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private ManagerServiceImpl managerService;

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Object registerStudent(String StudentName, String StudentTel, String StudentEmail, String StudentPwd){
        JSONObject jsonObject = new JSONObject();
        try{
            String status;
            if(studentService.findByStudentTel(StudentTel) != null){
                status =  "0";
            }else if(studentService.findByStudentEmail(StudentEmail) != null){
                status =  "1";
            }else{
                String studentId = GenerateId.generateId();
                Student student = new Student(studentId,StudentName,StudentTel,StudentEmail,StudentPwd, "0");
                studentService.save(student);
                jsonObject.put("StudentId", studentId);
                status =  "2";
            }
            jsonObject.put("status",status);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public String registerTeacher(@ModelAttribute Teacher teacher){
        if(teacherService.findByTeacherTel(teacher.getTeacherTel()) != null){
            return "0";
        }else if(teacherService.findByTeacherEmail(teacher.getTeacherEmail()) != null){
            return "1";
        }else{
            String teacherId = GenerateId.generateId();
            teacher.setTeacherId(teacherId);
            teacherService.save(teacher);
            return "2";
        }
    }
}
