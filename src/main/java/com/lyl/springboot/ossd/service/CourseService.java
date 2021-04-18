package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    void save(Course course);

    void deleteById(String courseId);

    Course findByCourseId(String CourseId);

    Course findByCourseName(String CourseName);

    Page<Course> findByCourseType(String CourseType, Pageable pageable);

    Page<Course> findAll(Pageable pageable);

    Page<Course> findByTeacherId(String TeacherId, Pageable pageable);

    Page<Course> findByTeacherIdAndAndCourseNameIsLike(String TeacherId, String CourseName, Pageable pageable);

    int modifyCourseNameById(String CourseName,String CourseId);

    int modifyCourseTypeById(String CourseType,String CourseId);

    int modifyCourseDesById(String CourseDes,String CourseId);

    int modifyCourseIndexById(String CourseIndex,String CourseId);

    int modifyCoursePreStudyById(String PreStudy,String CourseId);

    int modifyCourseBookById(String CourseBook,String CourseId);

}
