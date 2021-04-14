package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.UserCourseRelation;
import com.lyl.springboot.ossd.repository.UserCourseRelationRepository;
import com.lyl.springboot.ossd.service.UserCourseRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserCourseRelationServiceImpl implements UserCourseRelationService {
    @Autowired
    private UserCourseRelationRepository userCourseRelationRepository;


    @Override
    public void save(UserCourseRelation userCourseRelation) {
        userCourseRelationRepository.save(userCourseRelation);
    }

    @Override
    public void deleteByCourseUserId(Integer courseUserId) {
        userCourseRelationRepository.deleteById(courseUserId);
    }

    @Override
    public UserCourseRelation findByCourseIdAndStudentId(String courseId, String studentId) {
        return userCourseRelationRepository.findByCourseIdAndStudentId(courseId, studentId);
    }

    @Override
    public Page<UserCourseRelation> findByCourseUserId(String courseUserId, Pageable pageable) {
        return userCourseRelationRepository.findByCourseId(courseUserId, pageable);
    }

    @Override
    public Page<UserCourseRelation> findByCourseId(String courseId, Pageable pageable) {
        return userCourseRelationRepository.findByCourseId(courseId, pageable);
    }

    @Override
    public Page<UserCourseRelation> findByStudentId(String studentId, Pageable pageable) {
        return userCourseRelationRepository.findByStudentId(studentId, pageable);
    }

    @Override
    public Page<UserCourseRelation> findByType(int type, Pageable pageable) {
        return userCourseRelationRepository.findByType(type, pageable);
    }

    @Override
    public Page<UserCourseRelation> findByCourseIdAndType(String courseId, String type, Pageable pageable) {
        return userCourseRelationRepository.findByCourseIdAndType(courseId, type, pageable);
    }

    @Override
    public Page<UserCourseRelation> findByStudentIdAndType(String studentId, String type, Pageable pageable) {
        return userCourseRelationRepository.findByStudentIdAndType(studentId, type, pageable);
    }

    @Override
    public int modifyTypeByCourseUserId(int type, int courseUserId) {
        return userCourseRelationRepository.modifyTypeByCourseUserId(type, courseUserId);
    }
}
