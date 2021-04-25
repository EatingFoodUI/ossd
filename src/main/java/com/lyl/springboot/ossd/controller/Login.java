package com.lyl.springboot.ossd.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyl.springboot.ossd.domain.Student;
import com.lyl.springboot.ossd.domain.Teacher;
import com.lyl.springboot.ossd.service.ServiceImplement.ManagerServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.StudentServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.TeacherServiceImpl;
import com.lyl.springboot.ossd.utils.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
public class Login {
    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private ManagerServiceImpl managerService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/Student", method = RequestMethod.POST)
    public Object loginStudent(String StudentId, String StudentPwd){
        // @RequestParam Map<String,Object> reqMap,
        // String username = reqMap.get("StudentId").toString();
        JSONObject jsonObject = new JSONObject();
        try{
            Student student = studentService.findByStudentId(StudentId);
            String status;
            if(student == null){
                status = "0";
            }else if(!StudentPwd.equals(student.getStudentPwd())){
                status = "1";
            }else{
                status = "2";
                String token = tokenService.getToken(student.getStudentId(),student.getStudentPwd());
                jsonObject.put("token",token);
            }
            jsonObject.put("status",status);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    // @Resource
    // private AuthenticationManager authenticationManager;

    // @Resource
    // private TokenUtils tokenUtils;

    @RequestMapping(value = "/Teacher", method = RequestMethod.POST)
    public Object loginTeacher(String TeacherId, String TeacherPwd){
        // @RequestParam Map<String,Object> reqMap,
        // String username = reqMap.get("StudentId").toString();
        JSONObject jsonObject = new JSONObject();
        try{
            Teacher teacher = teacherService.findByTeacherId(TeacherId);
            String status;
            if(teacher == null){
                status = "0";
            }else if(!TeacherPwd.equals(teacher.getTeacherPwd())){
                status = "1";
            }else{
                status = "2";
                String token = tokenService.getToken(teacher.getTeacherId(),teacher.getTeacherPwd());
                jsonObject.put("token",token);
            }
            jsonObject.put("status",status);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }
}
