package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.Student;

public interface StudentService {
    void save(Student student);

    void deleteById(String studentId);

    Student findByStudentId(String StudentId);

    Student findByStudentTel(String StudentTel);

    Student findByStudentEmail(String StudentEmail);

    void modifyPwdById(String StudentPwd, String StudentId);

    void modifyTelById(String StudentTel, String StudentId);

    void modifyEmailById(String StudentEmail, String StudentId);
}
