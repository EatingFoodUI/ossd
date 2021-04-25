package com.lyl.springboot.ossd.controller;

import com.alibaba.fastjson.JSONObject;
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

    // 修改个人信息
    @RequestMapping(value = "/modifyPersonInfo", method = RequestMethod.POST)
    public String modifyPersonInfo(String status,
                                   String tel,
                                   String email,
                                   String colleague,
                                   String id){
        System.out.println(status);
        if(status.equals("1")){
            Student student = studentService.findByStudentId(id);
            if(tel != null){
                // 修改的电话已存在且不是自己之前保存的电话，修改失败
                if(studentService.findByStudentTel(tel) != null && !studentService.findByStudentTel(tel).getStudentId().equals(id)){
                    return "0";
                }
                student.setStudentTel(tel);
            }
            if(email != null){
                if(studentService.findByStudentEmail(email) != null && !studentService.findByStudentEmail(email).getStudentId().equals(id)){
                    return "1";
                }
                student.setStudentEmail(email);
            }
            studentService.modifyEmailAndTelById(email,tel,id);
            return "2";
        }else if(status.equals("2")){
            Teacher teacher = teacherService.findByTeacherId(id);
            if(tel != null){
                if(teacherService.findByTeacherTel(tel) != null && !teacherService.findByTeacherTel(tel).getTeacherId().equals(id)){
                    return "0";
                }
                teacher.setTeacherTel(tel);
            }
            if(email != null){
                if(teacherService.findByTeacherEmail(email) != null && !teacherService.findByTeacherId(id).getTeacherId().equals(id)){
                    return "1";
                }
                teacher.setTeacherEmail(email);
            }
            teacherService.modifyEmailAndTelById(email,tel,id);
            teacherService.modifyColleagueById(colleague,id);
            return "2";
        }
        return "-1";
    }

    // 修改头像
    @RequestMapping(value = "/modifyAccountPit", method = RequestMethod.POST)
    public String modifyAccountPit(String status,
                                   String id,
                                   MultipartFile multipartFile){
        System.out.println(multipartFile);
        // 通过pic存储
        try{
            // 绝对路径
            String filePathAb = filePath + multipartFile.getOriginalFilename();
            File file = new File(filePathAb);
            multipartFile.transferTo(file);

            AccountPit accountPit = accountPitService.findByAccount(id);
            if(accountPit == null){
                accountPit = new AccountPit(id,multipartFile.getOriginalFilename(),status);
            }else{
                accountPit.setPitAddr(multipartFile.getOriginalFilename());
            }
            accountPitService.save(accountPit);
        }catch (IOException e){
            e.printStackTrace();
            return "0";
        }

        return "1";
    }

    // 获取头像名称
    @RequestMapping(value = "/getAccountPit", method = RequestMethod.GET)
    public Object getAccountPit(@RequestParam("status") String status,
                                @RequestParam("id") String id){
        JSONObject json = new JSONObject();
        try{
            System.out.print("id:");
            System.out.println(id);
            System.out.print("status:");
            System.out.println(status);
            // 获取头像名称
            AccountPit accountPit = accountPitService.findByAccountAndWho(id,status);
            if(accountPit == null){
                json.put("status","1");
            }else{
                String pitAddr = accountPit.getPitAddr();
                json.put("pitAddr",pitAddr);
                json.put("status","2");
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("status","0");
        }
        return json;
    }

    // 获取密码
    @RequestMapping(value = "/getPwd", method = RequestMethod.GET)
    public Object getPwd(@RequestParam("status") String status,
                         @RequestParam("id") String id){
        JSONObject json = new JSONObject();
        try{
            System.out.print("id:");
            System.out.println(id);
            System.out.print("status:");
            System.out.println(status);
            // 获取密码
            // 老师
            if(status.equals("1")){
                Teacher teacher = teacherService.findByTeacherId(id);
                if(teacher == null){
                    json.put("status","0");
                }else{
                    json.put("pwd",teacher.getTeacherPwd());
                    json.put("status","1");
                }
            }else if(status.equals("2")){
                Student student = studentService.findByStudentId(id);
                if(student == null){
                    json.put("status","0");
                }else{
                    json.put("pwd",student.getStudentPwd());
                    json.put("status","1");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("status","0");
        }
        return json;
    }

    // 修改密码
    @RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
    public String resetPwd(@RequestParam("status") String status,
                           @RequestParam("id") String id,
                           @RequestParam("pwd") String pwd){
        JSONObject json = new JSONObject();
        try{
            // 老师
            if(status.equals("1")){
                Teacher teacher = teacherService.findByTeacherId(id);
                if(teacher == null && pwd.equals("")){
                    return "0";
                }else{
                    teacher.setTeacherPwd(pwd);
                    teacherService.save(teacher);
                    return "1";
                }
            }else if(status.equals("2")){
                Student student = studentService.findByStudentId(id);
                if(student == null && pwd.equals("")){
                    return "0";
                }else{
                    student.setStudentPwd(pwd);
                    studentService.save(student);
                    return "1";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}
