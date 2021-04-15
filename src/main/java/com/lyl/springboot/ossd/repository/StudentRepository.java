package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    Student findByStudentId(String StudentId);

    Student findByStudentTel(String StudentTel);

    Student findByStudentEmail(String StudentEmail);

    Student findByStudentEmailAndStudentTel(String StudentEmail, String StudentTel);

    // Page<Student> findByAuthentication(int authentication, Pageable pageable);

    /*
    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Student set authentication=?1 where studentId=?2")
    int modifyAuthenById(int authentication,String StudentId);
    */

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Student set studentPwd=?1 where studentId=?2")
    int modifyPwdById(String StudentPwd,String StudentId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Student set studentTel=?1 where studentId=?2")
    int modifyTelById(String StudentTel,String StudentId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Student set studentEmail=?1 where studentId=?2")
    int modifyEmailById(String StudentEmail,String StudentId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Student set studentEmail=?1, studentTel=?2 where studentId=?3")
    int modifyEmailAndTelById(String Email,String Tel, String Id);
}
