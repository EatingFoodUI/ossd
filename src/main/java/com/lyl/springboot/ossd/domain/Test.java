package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Test {
    @Id
    @Column(nullable = false, unique = true)
    private String testId;

    @Column(nullable = false, unique = false)
    private String courseId;

    @Column(nullable = false, unique = true)
    private String testName;

    @Column(nullable = false, unique = false)
    private Date createTime;

    @Column(nullable = false, unique = false)
    private Integer score;

    public Test(){

    }

    public Test(String testId, String courseId, String testName, Date createTime, Integer score) {
        this.testId = testId;
        this.courseId = courseId;
        this.testName = testName;
        this.createTime = createTime;
        this.score = score;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
