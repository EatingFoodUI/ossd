package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.UserCourseRelation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserCourseRelationService {

    void save(UserCourseRelation userCourseRelation);

    void deleteByCourseUserId(Integer courseUserId);

    UserCourseRelation findByCourseIdAndStudentId(String courseId, String studentId);

    Page<UserCourseRelation> findByCourseUserId(String courseUserId, Pageable pageable);

    Page<UserCourseRelation> findByCourseId(String CourseId, Pageable pageable);

    Page<UserCourseRelation> findByStudentId(String StudentId, Pageable pageable);

    Page<UserCourseRelation> findByType(int type, Pageable pageable);

    Page<UserCourseRelation> findByCourseIdAndType(String CourseId, String Type, Pageable pageable);

    Page<UserCourseRelation> findByStudentIdAndType(String StudentId, String Type, Pageable pageable);

    int modifyTypeByCourseUserId(int type,int courseUserId);

}
