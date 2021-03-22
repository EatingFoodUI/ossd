package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScoreService {

    void save(Score score);

    void deleteByScoreId(int scoreId);

    void deleteByTestId(String testId);

    void deleteByUserId(String UserId);

    Score findByScoreId(int ScoreId);

    Page<Score> findByTestId(String TestId, Pageable pageable);

    Page<Score> findByUserId(String UserId, Pageable pageable);

}
