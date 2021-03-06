package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Course {
    @Id
    @Column(nullable = false, unique = true)
    private String courseId;

    @Column(nullable = true, unique = true)
    private String courseName;

    @Column(nullable = true, unique = false)
    private String courseType;

    @Column(nullable = true, unique = false)
    private String courseDes;

    @Column(nullable = true, unique = false)
    private Integer courseLessonSum;

    @Column(nullable = true, unique = false)
    private String courseIndex;

    @Column(nullable = true, unique = false)
    private String preStudy;

    @Column(nullable = true, unique = false)
    private String courseBook;

    @Column(nullable = true, unique = false)
    private String teacherId;

    @Column(nullable = true, unique = false)
    private Date createTime;

    @Column(nullable = true, unique = false)
    private Integer collectCount;

    @Column(nullable = true, unique = false)
    private Integer evaluationCount;

    // 是否通过审核
    @Column(nullable = true, unique = false)
    private String courseVertify;

    public Course(){
        this.createTime = new Date();
    }

    public Course(String courseId, String courseName, String courseType, String courseDes, Integer courseLessonSum, String courseIndex, String preStudy, String courseBook, String teacherId, Date createTime, Integer collectCount, Integer evaluationCount, String courseVertify) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseDes = courseDes;
        this.courseLessonSum = courseLessonSum;
        this.courseIndex = courseIndex;
        this.preStudy = preStudy;
        this.courseBook = courseBook;
        this.teacherId = teacherId;
        this.createTime = createTime;
        this.collectCount = collectCount;
        this.evaluationCount = evaluationCount;
        this.courseVertify = courseVertify;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseDes() {
        return courseDes;
    }

    public void setCourseDes(String courseDes) {
        this.courseDes = courseDes;
    }

    public Integer getCourseLessonSum() {
        return courseLessonSum;
    }

    public void setCourseLessonSum(Integer courseLessonSum) {
        this.courseLessonSum = courseLessonSum;
    }

    public String getCourseIndex() {
        return courseIndex;
    }

    public void setCourseIndex(String courseIndex) {
        this.courseIndex = courseIndex;
    }

    public String getPreStudy() {
        return preStudy;
    }

    public void setPreStudy(String preStudy) {
        this.preStudy = preStudy;
    }

    public String getCourseBook() {
        return courseBook;
    }

    public void setCourseBook(String courseBook) {
        this.courseBook = courseBook;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getEvaluationCount() {
        return evaluationCount;
    }

    public void setEvaluationCount(Integer evaluationCount) {
        this.evaluationCount = evaluationCount;
    }

    public String getCourseVertify() {
        return courseVertify;
    }

    public void setCourseVertify(String courseVertify) {
        this.courseVertify = courseVertify;
    }
}
