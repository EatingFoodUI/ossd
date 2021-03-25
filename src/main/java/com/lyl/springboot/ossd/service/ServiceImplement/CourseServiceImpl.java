package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.Course;
import com.lyl.springboot.ossd.repository.CourseRepository;
import com.lyl.springboot.ossd.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteById(String courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course findByCourseId(String CourseId) {
        return courseRepository.findByCourseId(CourseId);
    }

    @Override
    public Course findByCourseName(String CourseName) {
        return courseRepository.findByCourseName(CourseName);
    }

    @Override
    public Page<Course> findByCourseType(String CourseType, Pageable pageable) {
        return courseRepository.findByCourseType(CourseType, pageable);
    }

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Page<Course> findByTeacherId(String TeacherId, Pageable pageable) {
        return courseRepository.findByTeacherId(TeacherId, pageable);
    }

    @Override
    public int modifyCourseNameById(String CourseName, String CourseId) {
        return courseRepository.modifyCourseNameById(CourseName, CourseId);
    }

    @Override
    public int modifyCourseTypeById(String CourseType, String CourseId) {
        return courseRepository.modifyCourseTypeById(CourseType, CourseId);
    }

    @Override
    public int modifyCourseDesById(String CourseDes, String CourseId) {
        return courseRepository.modifyCourseDesById(CourseDes, CourseId);
    }

    @Override
    public int modifyCourseIndexById(String CourseIndex, String CourseId) {
        return courseRepository.modifyCourseIndexById(CourseIndex, CourseId);
    }

    @Override
    public int modifyCoursePreStudyById(String PreStudy, String CourseId) {
        return courseRepository.modifyCoursePreStudyById(PreStudy, CourseId);
    }

    @Override
    public int modifyCourseBookById(String CourseBook, String CourseId) {
        return courseRepository.modifyCourseBookById(CourseBook, CourseId);
    }
}
