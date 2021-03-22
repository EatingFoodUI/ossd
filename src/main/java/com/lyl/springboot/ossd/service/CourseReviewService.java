package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.CourseReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseReviewService {

    void save(CourseReview courseReview);

    void deleteById(String msgId);

    String findByMsgId(String MsgId);

    Page<CourseReview> findByCourseId(String CourseId, Pageable pageable);

    Page<CourseReview> findByUserId(String UserId, Pageable pageable);

}
