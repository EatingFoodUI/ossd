package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.UserCourseRelation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserCourseRelationRepository extends JpaRepository<UserCourseRelation, Integer> {
    UserCourseRelation findByCourseUserId(String courseUserId);

    Page<UserCourseRelation> findByCourseId(String CourseId, Pageable pageable);

    Page<UserCourseRelation> findByStudentId(String StudentId, Pageable pageable);

    Page<UserCourseRelation> findByType(int type, Pageable pageable);

    Page<UserCourseRelation> findByCourseIdAndType(String CourseId, String Type, Pageable pageable);

    Page<UserCourseRelation> findByStudentIdAndType(String StudentId, String Type, Pageable pageable);

    @Transactional(timeout = 10)
    @Modifying
    @Query("UPDATE Course set type=?1 where courseUserId=?2")
    int modifyTypeByCourseUserId(String type,String courseUserId);
}
