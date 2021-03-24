package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    void save(Teacher teacher);

    void deleteById(String teacherId);

    Teacher findByTeacherId(String TeacherId);

    Teacher findByTeacherTel(String TeacherTel);

    Teacher findByTeacherEmail(String TeacherEmail);

    Teacher findByTeacherEmailAndTeacherTel(String TeacherEmail, String TeacherTel);

    Page<Teacher> findByTeacherName(String TeacherName, Pageable pageable);

    Page<Teacher> findByTeacherColleague(String TeacherColleague, Pageable pageable);

    Page<Teacher> findByAuthentication(int authentication, Pageable pageable);

    int modifyAuthenById(int authentication,String teacherId);

    void modifyPwdById(String TeacherPwd, String TeacherId);

    void modifyColleagueById(String TeacherColleague, String TeacherId);

    void modifyTelById(String TeacherTel, String TeacherId);

    void modifyEmailById(String TeacherEmail, String TeacherId);

    void modifyEmailAndTelById(String Email,String Tel, String Id);
}
