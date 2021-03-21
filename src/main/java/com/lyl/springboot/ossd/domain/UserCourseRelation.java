package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class UserCourseRelation {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Integer cSRId;

    @Column(nullable = false, unique = false)
    private String courseId;

    @Column(nullable = false, unique = false)
    private String studentId;

    @Column(nullable = false, unique = false)
    private Date createTime;

    @Column(nullable = false, unique = false)
    private Integer type;

    public UserCourseRelation(){

    }

    public UserCourseRelation(Integer cSRId, String courseId, String studentId, Date createTime, Integer type) {
        this.cSRId = cSRId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.createTime = createTime;
        this.type = type;
    }

    public Integer getcSRId() {
        return cSRId;
    }

    public void setcSRId(Integer cSRId) {
        this.cSRId = cSRId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
