package com.lyl.springboot.ossd.service;

import com.lyl.springboot.ossd.domain.CourseType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseTypeService {

    Page<CourseType> findAll(Pageable pageable);

    void save(CourseType course);

    // 根据id找
    CourseType findByCourseTypeId(String CourseTypeId);

    // 根据level找
    Page<CourseType> findByCourseTypeLevel(int CourseTypeLevel, Pageable pageable);

    // 根据id删
    void deleteByCourseId(String CourseId);

    // 根据name找
    CourseType findByCourseTypeName(String courseTypeName);
}
