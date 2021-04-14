package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.domain.Course;
import com.lyl.springboot.ossd.domain.UserCourseRelation;
import com.lyl.springboot.ossd.service.ServiceImplement.CourseServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.QuestionServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.TestServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.UserCourseRelationServiceImpl;
import com.lyl.springboot.ossd.utils.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/CourseStudy")
public class CourseStudy {
    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private TestServiceImpl testService;

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private UserCourseRelationServiceImpl userCourseRelationService;

    @RequestMapping("/joinCourseStudy")
    public String joinCourseStudy(@RequestParam("courseId") String courseId,
                                  @RequestParam("studentId") String studentId){
        UserCourseRelation userCourseRelation = userCourseRelationService.findByCourseIdAndStudentId(courseId, studentId);
        if(userCourseRelation == null){
            userCourseRelation = new UserCourseRelation();
            userCourseRelation.setCourseId(courseId);
            userCourseRelation.setStudentId(studentId);
            userCourseRelation.setCreateTime(new Date());
            userCourseRelation.setType(1);

            userCourseRelationService.save(userCourseRelation);
            return "1";
        }else if(userCourseRelation.getType() == 2){
            userCourseRelationService.modifyTypeByCourseUserId(3,userCourseRelation.getcSRId());
            return "1";
        }
        return "0";
    }

    @RequestMapping("/doCourseStudy")
    public String doCourseStudy(@RequestParam("course") Course course){
        return null;
    }

    @RequestMapping("/doCourseCount")
    public String doCourseCount(@RequestParam("course") Course course){
        return null;
    }

    @RequestMapping("/viewCount")
    public int viewCount(@RequestParam("courseId") String courseId){
        try{
            return courseService.findByCourseId(courseId).getEvaluationCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @RequestMapping("/doCollect")
    public String doCollect(@RequestParam("courseId") String courseId){
        return null;
    }
}
