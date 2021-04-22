package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.domain.CourseType;
import com.lyl.springboot.ossd.service.ServiceImplement.CourseTypeServiceImpl;
import com.lyl.springboot.ossd.utils.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ManageCourseType")
public class ManagerCourseType {

    @Autowired
    private CourseTypeServiceImpl courseTypeService;

    // 根据课程id获取单个课程分类信息
    @RequestMapping("/viewCourseTypeById")
    public Object viewCourseTypeByLevel(@RequestParam("courseTypeId") String courseTypeId){
        try{
            // 展示所有分类词条
            CourseType courseType = courseTypeService.findByCourseTypeId(courseTypeId);
            if(courseType == null){
                return "{'status':0}";
            }
            return courseType;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{status:0}";
    }

    // 根据课程分类层级获取课程分类
    @RequestMapping("/viewCourseTypeByLevel")
    public Object viewCourseTypeByLevel(@RequestParam("courseTypeLevel") int courseTypeLevel,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pagesize") int pagesize){
        try{
            // 展示所有分类词条
            if(courseTypeLevel == 0){
                return courseTypeService.findAll(PageRequest.of(pageNum-1,pagesize));
            }
            // jpa的page默认是从0开始读的，前端传入的page从1开始。
            Pageable pageable = PageRequest.of(pageNum-1, pagesize);
            Page<CourseType> allCourseType = courseTypeService.findByCourseTypeLevel(courseTypeLevel,pageable);
            return allCourseType;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{status:0}";
    }

    // 添加课程分类
    // 默认只能添加三级分类
    @RequestMapping("/addCourseType")
    public Object addCourseType(String CourseTypeName, String CourseTypePid){
        try{
            if(courseTypeService.findByCourseTypeName(CourseTypeName) != null){
                // 已经有相同名字的课程分类了
                return "{status:2}";
            }
            String courseTypeId = GenerateId.generateId();
            System.out.println(courseTypeId);
            CourseType courseType = new CourseType(courseTypeId,CourseTypeName,CourseTypePid,3);
            courseTypeService.save(courseType);
            // 添加成功
            return "{status:1}";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{'status':0}";
    }

    // 根据课程分类id删除课程分类
    // 默认三级
    @RequestMapping("/deleteCourseTypeById")
    public String deleteCourseTypeById(@RequestParam("courseTypeId") String courseTypeId){
        try{
            System.out.println(courseTypeId);
            courseTypeService.deleteByCourseId(courseTypeId);
            return "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    // 根据课程分类id修改课程分类名称
    // 默认三级
    @RequestMapping("/editCourseTypeById")
    public String editCourseTypeById(String courseTypeId,String courseTypeName){
        try{
            CourseType courseType = courseTypeService.findByCourseTypeId(courseTypeId);
            if(courseType == null){
                return "{'status':0}";
            }
            courseType.setCourseTypeName(courseTypeName);
            courseTypeService.save(courseType);
            return "{'status':1}";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{'status':0}";
    }
}
