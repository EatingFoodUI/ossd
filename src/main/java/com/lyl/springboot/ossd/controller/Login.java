package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.service.ServiceImplement.ManagerServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.StudentServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Login {
    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private ManagerServiceImpl managerService;

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
