package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    void save(Student student);

    void deleteById(String studentId);

    Student findByStudentId(String StudentId);

    Student findByStudentTel(String StudentTel);

    Student findByStudentEmail(String StudentEmail);

    Student findByStudentEmailAndStudentTel(String StudentEmail, String StudentTel);

    // 通过是否审核查询学生
    Page<Student> findByStudentVertify(String Vertify, Pageable pageable);

    //Page<Student> findByAuthentication(int authentication, Pageable pageable);

    //int modifyAuthenById(int authentication,String StudentId);

    void modifyPwdById(String StudentPwd, String StudentId);

    void modifyTelById(String StudentTel, String StudentId);

    void modifyEmailById(String StudentEmail, String StudentId);

    void modifyEmailAndTelById(String Email,String Tel, String Id);
}
