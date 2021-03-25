package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.domain.Course;
import com.lyl.springboot.ossd.service.ServiceImplement.CourseServiceImpl;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/view")
public class view {

    @Autowired
    private CourseServiceImpl courseService;

    @RequestMapping(value = "/allCourses", method = RequestMethod.GET)
    public Page<Course> ViewAllCourses(@RequestParam("page") int page){
        try {
            Pageable pageable = PageRequest.of(page, 20);
            Page<Course> allCourses = courseService.findAll(pageable);
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
}
