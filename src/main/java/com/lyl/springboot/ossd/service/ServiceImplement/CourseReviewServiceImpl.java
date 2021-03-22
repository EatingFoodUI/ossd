package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.CourseReview;
import com.lyl.springboot.ossd.repository.CourseReviewRepository;
import com.lyl.springboot.ossd.service.CourseReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseReviewServiceImpl implements CourseReviewService {
    @Autowired
    private CourseReviewRepository courseReviewRepository;

    @Override
    public void save(CourseReview courseReview) {
        courseReviewRepository.save(courseReview);
    }

    @Override
    public void deleteById(String msgId) {
        courseReviewRepository.deleteById(msgId);
    }

    @Override
    public String findByMsgId(String MsgId) {
        return courseReviewRepository.findByMsgId(MsgId);
    }

    @Override
    public Page<CourseReview> findByCourseId(String courseId, Pageable pageable) {
        return courseReviewRepository.findByCourseId(courseId, pageable);
    }

    @Override
    public Page<CourseReview> findByUserId(String userId, Pageable pageable) {
        return courseReviewRepository.findByUserId(userId, pageable);
    }
}
