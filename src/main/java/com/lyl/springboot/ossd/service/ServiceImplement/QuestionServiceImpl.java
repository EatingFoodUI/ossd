package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.Question;
import com.lyl.springboot.ossd.repository.QuestionRepository;
import com.lyl.springboot.ossd.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void deleteByTestId(String testId) {
        questionRepository.deleteByTestId(testId);
    }

    @Override
    public void deleteByQueId(String queId) {
        questionRepository.deleteById(queId);
    }

    @Override
    public Page<Question> findByTestId(String testId, Pageable pageable) {
        return questionRepository.findByTestId(testId, pageable);
    }

    @Override
    public Question findByQueId(String queId) {
        return questionRepository.findByQueId(queId);
    }
}
