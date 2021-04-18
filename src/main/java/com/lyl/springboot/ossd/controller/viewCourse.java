package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.domain.Course;
import com.lyl.springboot.ossd.service.ServiceImplement.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 查看课程详细信息
@RestController
@RequestMapping("/viewCourse")
public class viewCourse {

    @Autowired
    private CourseServiceImpl courseService;

    @RequestMapping(value = "/viewCourseInfo", method = RequestMethod.GET)
    public Course viewCourseInfo(@RequestParam("courseId") String courseId){
        try {
            Course course = courseService.findByCourseId(courseId);
            System.out.println(course.getCourseName());
            return course;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
