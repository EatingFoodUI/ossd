package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,String> {
    Teacher findByTeacherId(String TeacherId);

    Teacher findByTeacherTel(String TeacherTel);

    Teacher findByTeacherEmail(String TeacherEmail);

    Page<Teacher> findByTeacherName(String TeacherName, Pageable pageable);

    Page<Teacher> findByTeacherColleague(String TeacherColleague, Pageable pageable);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Teacher set teacherPwd =?1 where teacherId=?2")
    int modifyPwdById(String TeacherPwd,String TeacherId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Teacher set teacherColleague =?1 where teacherId=?2")
    int modifyColleagueById(String TeacherColleague,String TeacherId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Teacher set teacherTel =?1 where teacherId=?2")
    int modifyTelById(String TeacherTel,String TeacherId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Teacher set teacherEmail =?1 where teacherId=?2")
    int modifyEmailById(String TeacherEmail,String TeacherId);
}
