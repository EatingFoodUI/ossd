package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Lancaster Li
 */
@Entity
public class Student {
    @Id
    @Column(nullable = false, unique = true)
    private String studentId;

    @Column(nullable = false, unique = false)
    private String studentName;

    @Column(nullable = true, unique = true)
    private String studentTel;

    @Column(nullable = true, unique = true)
    private String studentEmail;

    @Column(nullable = false, unique = false)
    private String studentPwd;

    @Column(nullable = false, unique = false)
    private Integer authentication = 0;

    public Student(){

    }

    public Student(String studentId, String studentName, String studentTel, String studentEmail, String studentPwd, Integer authentication) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentTel = studentTel;
        this.studentEmail = studentEmail;
        this.studentPwd = studentPwd;
        this.authentication = authentication;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentTel() {
        return studentTel;
    }

    public void setStudentTel(String studentTel) {
        this.studentTel = studentTel;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }
}
