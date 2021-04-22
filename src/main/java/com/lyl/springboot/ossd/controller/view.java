package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.domain.Course;
import com.lyl.springboot.ossd.domain.Student;
import com.lyl.springboot.ossd.domain.Teacher;
import com.lyl.springboot.ossd.service.ServiceImplement.CourseServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.StudentServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.TeacherServiceImpl;
import com.lyl.springboot.ossd.service.StudentService;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


// 查看课程索引信息
@RestController
@RequestMapping("/view")
public class view {

    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @RequestMapping(value = "/TeacherAllCourse", method = RequestMethod.GET)
    public Page<Course> ViewTeacherAllCourse(@RequestParam("teacherId") String teacherId,
                                       @RequestParam("query") String query,
                                       @RequestParam("pagenum") int pagenum,
                                       @RequestParam("pageSize") int pageSize){
        try {
            // jpa的page默认是从0开始读的，前端传入的page从1开始。
            Pageable pageable = PageRequest.of(pagenum-1, pageSize);
            Page<Course> allCourses = courseService.findByTeacherIdAndAndCourseNameIsLike(teacherId,"%"+query+"%",pageable);
            return allCourses;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/typeCourses", method = RequestMethod.GET)
    public Page<Course> ViewTypeCourses(@RequestParam("type") String type,
                                        @RequestParam("page") int page){
        try{
            Pageable pageable = PageRequest.of(page, 20);
            Page<Course> allCourses = courseService.findByCourseType(type, pageable);
            return allCourses;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // 通过学生id查询学生信息
    @RequestMapping(value = "/StudentInfo", method = RequestMethod.GET)
    public Object StudentInfo(@RequestParam("studentId") String StudentId){
        try{
            if(StudentId == null){
                return "0";
            }
            Student student = studentService.findByStudentId(StudentId);
            if(student == null){
                return "0";
            }
            return student;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // 通过老师id查询老师信息
    @RequestMapping(value = "/TeacherInfo", method = RequestMethod.GET)
    public Object TeacherInfo(@RequestParam("teacherId") String TeacherId){
        try{
            if(TeacherId == null){
                return "0";
            }
            Teacher teacher = teacherService.findByTeacherId(TeacherId);
            if(teacher == null){
                return "0";
            }
            return teacher;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
