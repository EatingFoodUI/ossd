package com.lyl.springboot.ossd.domain;

import javax.persistence.*;

@Entity
public class CourseType {
    @Id
    @Column(nullable = false, unique = true)
    private String courseTypeId;

    @Column(nullable = false, unique = true)
    private String courseTypeName;

    @Column(nullable = true, unique = false)
    private String courseTypePid;

    @Column(nullable = false, unique = false)
    private Integer courseTypeLevel;

    public CourseType(){

    }

    public CourseType(String courseTypeId, String courseTypeName, String courseTypePid, Integer courseTypeLevel) {
        this.courseTypeId = courseTypeId;
        this.courseTypeName = courseTypeName;
        this.courseTypePid = courseTypePid;
        this.courseTypeLevel = courseTypeLevel;
    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    public String getCourseTypePid() {
        return courseTypePid;
    }

    public void setCourseTypePid(String courseTypePid) {
        this.courseTypePid = courseTypePid;
    }

    public Integer getCourseTypeLevel() {
        return courseTypeLevel;
    }

    public void setCourseTypeLevel(Integer courseTypeLevel) {
        this.courseTypeLevel = courseTypeLevel;
    }
}
