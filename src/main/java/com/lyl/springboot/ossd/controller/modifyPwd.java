package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.service.ServiceImplement.StudentServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class modifyPwd {
    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/modifyPwd")
    public String modify(@RequestParam("pwd") String pwd,
                         @RequestParam("id") String id,
                         @RequestParam("status") String status){
        try{
            if(status == "1"){
                studentService.modifyPwdById(pwd,id);
            }else if(status == "2"){
                teacherService.modifyPwdById(pwd,id);
            }
        }catch(Exception e){
            e.printStackTrace();
            return "0";
        }
        return "1";
    }
}
