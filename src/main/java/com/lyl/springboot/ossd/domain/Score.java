package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Score {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private String scoreId;

    @Column(nullable = false, unique = false)
    private String testId;

    @Column(nullable = false, unique = false)
    private String userId;

    @Column(nullable = false, unique = false)
    private Date createTime;

    @Column(nullable = false, unique = false)
    private Integer score;

    public Score(){

    }

    public Score(String scoreId, String testId, String userId, Date createTime, Integer score) {
        this.scoreId = scoreId;
        this.testId = testId;
        this.userId = userId;
        this.createTime = createTime;
        this.score = score;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
