package com.lyl.springboot.ossd.domain;

import javax.persistence.*;

@Entity
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer courseTypeId;

    @Column(nullable = false, unique = true)
    private String courseTypeName;

    public CourseType(){

    }

    public CourseType(Integer courseTypeId, String courseTypeName) {
        this.courseTypeId = courseTypeId;
        this.courseTypeName = courseTypeName;
    }

    public Integer getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Integer courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }
}
