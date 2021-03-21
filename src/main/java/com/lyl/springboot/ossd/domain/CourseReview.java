package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CourseReview {
    @Id
    @Column(nullable = false, unique = true)
    private String msgId;

    @Column(nullable = false, unique = false)
    private String courseId;

    @Column(nullable = false, unique = false)
    private String userId;

    @Column(nullable = false, unique = false)
    private Date createTime;

    @Column(nullable = false, unique = false)
    private Integer userType;

    @Column(nullable = false, unique = false)
    private String msg;

    @Column(nullable = false, unique = false)
    private Integer isRes;

    @Column(nullable = true, unique = false)
    private String resId;

    public CourseReview(){

    }

    public CourseReview(String msgId, String courseId, String userId, Date createTime, Integer userType, String msg, Integer isRes, String resId) {
        this.msgId = msgId;
        this.courseId = courseId;
        this.userId = userId;
        this.createTime = createTime;
        this.userType = userType;
        this.msg = msg;
        this.isRes = isRes;
        this.resId = resId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getIsRes() {
        return isRes;
    }

    public void setIsRes(Integer isRes) {
        this.isRes = isRes;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }
}
