package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.domain.Course;
import com.lyl.springboot.ossd.service.ServiceImplement.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viewCourse")
public class viewCourse {

    @Autowired
    private CourseServiceImpl courseService;

    @RequestMapping("/viewCourseInfo")
    public Course viewCourseInfo(@RequestParam("/courseId") String courseId){
        try {
            Course course = courseService.findByCourseId(courseId);
            return course;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
