package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TestService {

    void save(Test test);

    void deleteByTestId(String testId);

    String findByTestId(String TestId);

    Page<Test> findByCourseId(String CourseId, Pageable pageable);

}
