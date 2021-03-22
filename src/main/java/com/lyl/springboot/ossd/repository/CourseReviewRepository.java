package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.CourseReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseReviewRepository extends JpaRepository<CourseReview, String> {
    String findByMsgId(String MsgId);

    Page<CourseReview> findByCourseId(String CourseId, Pageable pageable);

    Page<CourseReview> findByUserId(String UserId, Pageable pageable);
}
