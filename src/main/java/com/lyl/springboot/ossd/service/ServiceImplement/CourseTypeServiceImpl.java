package com.lyl.springboot.ossd.service.ServiceImplement;

import com.lyl.springboot.ossd.domain.CourseType;
import com.lyl.springboot.ossd.repository.CourseTypeRepository;
import com.lyl.springboot.ossd.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Override
    public Page<CourseType> findAll(Pageable pageable) {
        return courseTypeRepository.findAll(pageable);
    }

    @Override
    public void save(CourseType course) {
        courseTypeRepository.save(course);
    }


    @Override
    public CourseType findByCourseTypeId(String CourseTypeId) {
        return courseTypeRepository.findByCourseTypeId(CourseTypeId);
    }

    @Override
    public Page<CourseType> findByCourseTypeLevel(int CourseTypeLevel, Pageable pageable) {
        return courseTypeRepository.findByCourseTypeLevel(CourseTypeLevel, pageable);
    }

    @Override
    public void deleteByCourseId(String CourseId) {
        courseTypeRepository.deleteById(CourseId);
    }

    @Override
    public CourseType findByCourseTypeName(String courseTypeName) {
        return courseTypeRepository.findByCourseTypeName(courseTypeName);
    }
}
