package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    Page<Question> findByTestId(String testId, Pageable pageable);

    Question findByQueId(String QueId);

    void deleteByTestId(String testId);
}
