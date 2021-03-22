package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    Score findByScoreId(int ScoreId);

    void deleteByTestId(String testId);

    void deleteByUserId(String userId);

    Page<Score> findByTestId(String TestId, Pageable pageable);

    Page<Score> findByUserId(String UserId, Pageable pageable);
}
