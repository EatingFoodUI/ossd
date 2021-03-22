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

    Page<Teacher> findByTeacherName(String TeacherName, Pageable pageable);

    Page<Teacher> findByTeacherColleague(String TeacherColleague, Pageable pageable);

    void modifyPwdById(String TeacherPwd, String TeacherId);

    void modifyColleagueById(String TeacherColleague, String TeacherId);

    void modifyTelById(String TeacherTel, String TeacherId);

    void modifyEmailById(String TeacherEmail, String TeacherId);
}
