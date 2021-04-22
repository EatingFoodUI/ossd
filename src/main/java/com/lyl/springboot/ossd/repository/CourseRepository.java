package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    Course findByCourseId(String CourseIf);

    Course findByCourseName(String CourseName);

    Page<Course> findByCourseType(String CourseType, Pageable pageable);

    @Override
    Page<Course> findAll(Pageable pageable);

    Page<Course> findByTeacherId(String TeacherId, Pageable pageable);

    // 通过老师账号和课程名称模糊查询
    Page<Course> findByTeacherIdAndAndCourseNameIsLike(String TeacherId, String CourseName, Pageable pageable);

    // 通过是否审核查询
    Page<Course> findByCourseVertify(String Vertify, Pageable pageable);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Course set courseName=?1 where courseId=?2")
    int modifyCourseNameById(String CourseName,String CourseId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Course set courseType=?1 where courseId=?2")
    int modifyCourseTypeById(String CourseType,String CourseId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Course set courseDes=?1 where courseId=?2")
    int modifyCourseDesById(String CourseDes,String CourseId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Course set courseIndex=?1 where courseId=?2")
    int modifyCourseIndexById(String CourseIndex,String CourseId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Course set preStudy=?1 where courseId=?2")
    int modifyCoursePreStudyById(String PreStudy,String CourseId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Course set courseBook=?1 where courseId=?2")
    int modifyCourseBookById(String CourseBook,String CourseId);

    // 老师查看自己创建的所有课程
}
