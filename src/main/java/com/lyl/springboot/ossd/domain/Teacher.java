package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
    @Id
    @Column(nullable = false, unique = true)
    private String teacherId;

    @Column(nullable = false, unique = false)
    private String teacherName;

    @Column(nullable = false, unique = false)
    private String teacherColleague;

    @Column(nullable = true, unique = true)
    private String teacherTel;

    @Column(nullable = true, unique = true)
    private String teacherEmail;

    @Column(nullable = true, unique = false)
    private String teacherPwd;

    @Column(nullable = false, unique = false)
    private Integer authentication = 0;

    public Teacher(){

    }

    public Teacher(String teacherId, String teacherName, String teacherColleague, String teacherTel, String teacherEmail, String teacherPwd, Integer authentication) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherColleague = teacherColleague;
        this.teacherTel = teacherTel;
        this.teacherEmail = teacherEmail;
        this.teacherPwd = teacherPwd;
        this.authentication = authentication;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherColleague() {
        return teacherColleague;
    }

    public void setTeacherColleague(String teacherColleague) {
        this.teacherColleague = teacherColleague;
    }

    public String getTeacherTel() {
        return teacherTel;
    }

    public void setTeacherTel(String teacherTel) {
        this.teacherTel = teacherTel;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }
}
