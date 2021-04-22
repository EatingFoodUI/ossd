package com.lyl.springboot.ossd.repository;

import com.lyl.springboot.ossd.domain.CourseType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTypeRepository extends JpaRepository<CourseType,String> {
    // 根据id找
    CourseType findByCourseTypeId(String CourseTypeId);

    // 根据type找
    Page<CourseType> findByCourseTypeLevel(int CourseTypeLevel, Pageable pageable);

    // 根据name找
    CourseType findByCourseTypeName(String courseTypeName);
}
