package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Question {
    @Id
    @Column(nullable = false, unique = true)
    private String queId;

    @Column(nullable = false, unique = false)
    private String testId;

    @Column(nullable = false, unique = false)
    private String queDes;

    @Column(nullable = false, unique = false)
    private String queA;
    @Column(nullable = false, unique = false)
    private String queB;
    @Column(nullable = false, unique = false)
    private String queC;
    @Column(nullable = false, unique = false)
    private String queD;

    @Column(nullable = false, unique = false)
    private String correct;

    @Column(nullable = false, unique = false)
    private Date createTime;

    public Question(){

    }

    public Question(String queId, String testId, String queDes, String queA, String queB, String queC, String queD, String correct, Date createTime) {
        this.queId = queId;
        this.testId = testId;
        this.queDes = queDes;
        this.queA = queA;
        this.queB = queB;
        this.queC = queC;
        this.queD = queD;
        this.correct = correct;
        this.createTime = createTime;
    }

    public String getQueId() {
        return queId;
    }

    public void setQueId(String queId) {
        this.queId = queId;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getQueDes() {
        return queDes;
    }

    public void setQueDes(String queDes) {
        this.queDes = queDes;
    }

    public String getQueA() {
        return queA;
    }

    public void setQueA(String queA) {
        this.queA = queA;
    }

    public String getQueB() {
        return queB;
    }

    public void setQueB(String queB) {
        this.queB = queB;
    }

    public String getQueC() {
        return queC;
    }

    public void setQueC(String queC) {
        this.queC = queC;
    }

    public String getQueD() {
        return queD;
    }

    public void setQueD(String queD) {
        this.queD = queD;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
