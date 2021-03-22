package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.Test;
import com.lyl.springboot.ossd.repository.TestRepository;
import com.lyl.springboot.ossd.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public void save(Test test) {
        testRepository.save(test);
    }

    @Override
    public void deleteByTestId(String testId) {
        testRepository.deleteById(testId);
    }

    @Override
    public String findByTestId(String testId) {
        return testRepository.findByTestId(testId);
    }

    @Override
    public Page<Test> findByCourseId(String courseId, Pageable pageable) {
        return testRepository.findByCourseId(courseId, pageable);
    }
}
