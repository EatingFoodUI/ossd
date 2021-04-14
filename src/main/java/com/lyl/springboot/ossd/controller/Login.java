package com.lyl.springboot.ossd.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyl.springboot.ossd.domain.Student;
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
        Student student = studentService.findByStudentId(StudentId);
        String status;
        if(student == null){
            status = "0";
        }else if(!StudentPwd.equals(student.getStudentPwd())){
            status = "1";
        }else{
            status = "2";
            String token = tokenService.getToken(student);
            jsonObject.put("token",token);
        }
        jsonObject.put("status",status);
        return jsonObject;
    }

    // @Resource
    // private AuthenticationManager authenticationManager;

    // @Resource
    // private TokenUtils tokenUtils;

    /**@RequestMapping(value = "/Student", method = RequestMethod.POST)
    public MyResponse loginStudent(@ModelAttribute Student student){
        Student student1 = studentService.findByStudentId(student.getStudentId());
        String status;
        if(student1 == null){
            status =  "0";
        }else if(student.getStudentPwd() != student1.getStudentPwd()){
            status =  "1";
        }

        // token
        status = "2";
        return new MyResponse(status, tokenUtils.createToken(student.getStudentId(), student.getAuthentication()));
    }**/
}
