package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.Student;
import com.lyl.springboot.ossd.repository.StudentRepository;
import com.lyl.springboot.ossd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(String studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student findByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    @Override
    public Student findByStudentTel(String studentTel) {
        return studentRepository.findByStudentTel(studentTel);
    }

    @Override
    public Student findByStudentEmail(String studentEmail) {
        return studentRepository.findByStudentEmail(studentEmail);
    }

    @Override
    public void modifyPwdById(String studentPwd, String studentId) {
        studentRepository.modifyPwdById(studentPwd, studentId);
    }

    @Override
    public void modifyTelById(String studentTel, String studentId) {
        studentRepository.modifyTelById(studentTel, studentId);
    }

    @Override
    public void modifyEmailById(String studentEmail, String studentId) {
        studentRepository.modifyEmailById(studentEmail, studentId);
    }
}
