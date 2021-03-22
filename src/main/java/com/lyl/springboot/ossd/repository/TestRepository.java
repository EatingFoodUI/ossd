package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, String> {
    String findByTestId(String TestId);

    Page<Test> findByCourseId(String CourseId, Pageable pageable);
}
