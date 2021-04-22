package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.domain.Student;
import com.lyl.springboot.ossd.domain.Teacher;
import com.lyl.springboot.ossd.service.ServiceImplement.StudentServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.TeacherServiceImpl;
import com.lyl.springboot.ossd.service.StudentService;
import com.lyl.springboot.ossd.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 审核老师和学生
@RestController
@RequestMapping("/Vertify")
public class Vertify {
    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private TeacherServiceImpl teacherService;

    // 通过是否审核查询老师
    @RequestMapping("/ViewTeacherByVertify")
    public Object ViewTeacherByVertify(@RequestParam("Vertify") String vertify,
                                  @RequestParam("pagenum") int pagenum,
                                  @RequestParam("pageSize") int pageSize){
        try{
            Pageable pageable = PageRequest.of(pagenum-1, pageSize);
            Page<Teacher> page = teacherService.findByTeacherVertify(vertify,pageable);
            return page;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    // 通过是否审核查询学生
    @RequestMapping("/ViewStudentByVertify")
    public Object ViewStudentByVertify(@RequestParam("Vertify") String vertify,
                                       @RequestParam("pagenum") int pagenum,
                                       @RequestParam("pageSize") int pageSize){
        try{
            Pageable pageable = PageRequest.of(pagenum-1, pageSize);
            Page<Student> page = studentService.findByStudentVertify(vertify,pageable);
            return page;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    // 审核学生
    @RequestMapping("/VertityStudentById")
    public String VertityStudentById(@RequestParam("studentId") String studentId){
        try{
            if(studentId == null){
                return "0";
            }
            Student student = studentService.findByStudentId(studentId);
            if(student == null){
                return "1";
            }
            student.setStudentVertify("1");
            studentService.save(student);
            return "2";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    // 审核老师
    @RequestMapping("/VertityTeacherById")
    public String VertityTeacherById(@RequestParam("teacherId") String TeacherId){
        try{
            if(TeacherId == null){
                return "0";
            }
            Teacher teacher = teacherService.findByTeacherId(TeacherId);
            if(teacher == null){
                return "1";
            }
            teacher.setTeacherVertify("1");
            teacherService.save(teacher);
            return "2";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}
