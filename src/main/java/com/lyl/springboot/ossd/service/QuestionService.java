package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {

    void save(Question question);

    void deleteByTestId(String testId);

    void deleteByQueId(String queId);

    Page<Question> findByTestId(String testId, Pageable pageable);

    Question findByQueId(String QueId);

}
