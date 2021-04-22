package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.Teacher;
import com.lyl.springboot.ossd.repository.TeacherRepository;
import com.lyl.springboot.ossd.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(String teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public Teacher findByTeacherId(String teacherId) {
        return teacherRepository.findByTeacherId(teacherId);
    }

    @Override
    public Teacher findByTeacherTel(String teacherTel) {
        return teacherRepository.findByTeacherTel(teacherTel);
    }

    @Override
    public Teacher findByTeacherEmail(String TeacherEmail) {
        return teacherRepository.findByTeacherEmail(TeacherEmail);
    }

    @Override
    public Teacher findByTeacherEmailAndTeacherTel(String TeacherEmail, String TeacherTel) {
        return teacherRepository.findByTeacherEmailAndTeacherTel(TeacherEmail, TeacherTel);
    }

    @Override
    public Page<Teacher> findByTeacherName(String TeacherName, Pageable pageable) {
        return teacherRepository.findByTeacherName(TeacherName, pageable);
    }

    @Override
    public Page<Teacher> findByTeacherColleague(String TeacherColleague, Pageable pageable) {
        return teacherRepository.findByTeacherColleague(TeacherColleague, pageable);
    }

    @Override
    public Page<Teacher> findByTeacherVertify(String Vertify, Pageable pageable) {
        return teacherRepository.findByTeacherVertify(Vertify,pageable);
    }

    @Override
    public int modifyAuthenById(int authentication, String teacherId) {
        return teacherRepository.modifyAuthenById(authentication, teacherId);
    }

    @Override
    public void modifyPwdById(String TeacherPwd, String TeacherId) {
        teacherRepository.modifyPwdById(TeacherPwd, TeacherId);
    }

    @Override
    public void modifyColleagueById(String TeacherColleague, String TeacherId) {
        teacherRepository.modifyColleagueById(TeacherColleague, TeacherId);
    }

    @Override
    public void modifyTelById(String TeacherTel, String TeacherId) {
        teacherRepository.modifyTelById(TeacherTel, TeacherId);
    }

    @Override
    public void modifyEmailById(String TeacherEmail, String TeacherId) {
        teacherRepository.modifyEmailById(TeacherEmail, TeacherId);
    }

    @Override
    public void modifyEmailAndTelById(String Email, String Tel, String Id) {
        teacherRepository.modifyEmailAndTelById(Email, Tel, Id);
    }
}
