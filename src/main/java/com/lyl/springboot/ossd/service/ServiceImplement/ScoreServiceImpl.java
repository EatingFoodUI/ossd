package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.Score;
import com.lyl.springboot.ossd.repository.ScoreRepository;
import com.lyl.springboot.ossd.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public void save(Score score) {
        scoreRepository.save(score);
    }

    @Override
    public void deleteByScoreId(int scoreId) {
        scoreRepository.deleteById(scoreId);
    }

    @Override
    public void deleteByTestId(String testId) {
        scoreRepository.deleteByTestId(testId);
    }

    @Override
    public void deleteByUserId(String userId) {
        scoreRepository.deleteByUserId(userId);
    }

    @Override
    public Score findByScoreId(int scoreId) {
        return scoreRepository.findByScoreId(scoreId);
    }

    @Override
    public Page<Score> findByTestId(String testId, Pageable pageable) {
        return scoreRepository.findByTestId(testId, pageable);
    }

    @Override
    public Page<Score> findByUserId(String userId, Pageable pageable) {
        return scoreRepository.findByUserId(userId, pageable);
    }
}
