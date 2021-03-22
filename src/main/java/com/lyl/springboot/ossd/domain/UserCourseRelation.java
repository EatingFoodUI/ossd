package com.lyl.springboot.ossd.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserCourseRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer courseUserId;

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

    public UserCourseRelation(Integer courseUserId, String courseId, String studentId, Date createTime, Integer type) {
        this.courseUserId = courseUserId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.createTime = createTime;
        this.type = type;
    }

    public Integer getcSRId() {
        return courseUserId;
    }

    public void setcSRId(Integer cSRId) {
        this.courseUserId = cSRId;
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
