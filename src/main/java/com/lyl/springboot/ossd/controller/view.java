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


// 查看课程索引信息
@RestController
@RequestMapping("/view")
public class view {

    @Autowired
    private CourseServiceImpl courseService;

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
}
