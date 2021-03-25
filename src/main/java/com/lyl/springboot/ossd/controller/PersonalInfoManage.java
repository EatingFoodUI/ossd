package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.domain.AccountPit;
import com.lyl.springboot.ossd.domain.Student;
import com.lyl.springboot.ossd.domain.Teacher;
import com.lyl.springboot.ossd.service.ServiceImplement.AccountPitServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.StudentServiceImpl;
import com.lyl.springboot.ossd.service.ServiceImplement.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/modify")
public class PersonalInfoManage {
    @Value("${PersonPit.addr}")
    private String filePath;

    private String fileName;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private AccountPitServiceImpl accountPitService;

    @RequestMapping(value = "/modifyPersonInfo", method = RequestMethod.POST)
    public String modifyPersonInfo(@RequestParam("status") String status,
                                   @RequestParam("Tel") String tel,
                                   @RequestParam("Email") String email,
                                   @RequestParam("colleague") String colleague,
                                   @RequestParam("id") String id){
        if(status == "1"){
            Student student = studentService.findByStudentId(id);
            if(tel != null){
                if(studentService.findByStudentTel(tel) != null){
                    return "0";
                }
                student.setStudentTel(tel);
            }
            if(email != null){
                if(studentService.findByStudentEmail(email) != null){
                    return "1";
                }
                student.setStudentEmail(email);
            }
            studentService.modifyEmailAndTelById(email,tel,id);
            return "2";
        }else if(status == "2"){
            Teacher teacher = teacherService.findByTeacherId(id);
            if(tel != null){
                if(teacherService.findByTeacherTel(tel) != null){
                    return "0";
                }
                teacher.setTeacherTel(tel);
            }
            if(email != null){
                if(teacherService.findByTeacherEmail(email) != null){
                    return "1";
                }
                teacher.setTeacherEmail(email);
            }
            teacherService.modifyEmailAndTelById(email,tel,id);
            return "2";
        }
        return "-1";
    }

    @RequestMapping(value = "/modifyAccountPit", method = RequestMethod.POST)
    public String modifyAccountPit(@RequestParam("status") String status,
                                   @RequestParam("id") String id,
                                   @RequestParam("pic") MultipartFile multipartFile){
        // 通过pic存储
        try{
            File file = new File(filePath + multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);

            AccountPit accountPit = accountPitService.findByAccount(id);
            if(accountPit == null){
                accountPit = new AccountPit(id,filePath+multipartFile,status);
            }else{
                accountPit.setPitAddr(filePath+multipartFile);
            }
            accountPitService.save(accountPit);
        }catch (IOException e){
            e.printStackTrace();
            return "0";
        }

        return "1";
    }

}
