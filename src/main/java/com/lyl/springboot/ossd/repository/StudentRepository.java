package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student,String> {
    Student findByStudentId(String StudentId);

    Student findByStudentTel(String StudentTel);

    Student findByStudentEmail(String StudentEmail);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Student set studentPwd=?1 where studentId=?2")
    int modifyPwdById(String StudentPwd,String StudentId);
}
