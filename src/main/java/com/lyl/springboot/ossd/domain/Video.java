package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Video {
    @Id
    @Column(nullable = false, unique = true)
    private String videoId;

    @Column(nullable = false, unique = true)
    private String videoName;

    @Column(nullable = false, unique = false)
    private String videoAuthor;

    @Column(nullable = true, unique = false)
    private String videoDes;

    @Column(nullable = false, unique = false)
    private String videoAdd;

    @Column(nullable = false, unique = false)
    private Date videoTime;

    @Column(nullable = false, unique = false)
    private String courseId;

    @Column(nullable = false, unique = false)
    private Integer courseLesson;

    public Video(){

    }

    public Video(String videoId, String videoName, String videoAuthor, String videoDes, String videoAdd, Date videoTime, String courseId, Integer courseLesson) {
        this.videoId = videoId;
        this.videoName = videoName;
        this.videoAuthor = videoAuthor;
        this.videoDes = videoDes;
        this.videoAdd = videoAdd;
        this.videoTime = videoTime;
        this.courseId = courseId;
        this.courseLesson = courseLesson;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoAuthor() {
        return videoAuthor;
    }

    public void setVideoAuthor(String videoAuthor) {
        this.videoAuthor = videoAuthor;
    }

    public String getVideoDes() {
        return videoDes;
    }

    public void setVideoDes(String videoDes) {
        this.videoDes = videoDes;
    }

    public String getVideoAdd() {
        return videoAdd;
    }

    public void setVideoAdd(String videoAdd) {
        this.videoAdd = videoAdd;
    }

    public Date getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Date videoTime) {
        this.videoTime = videoTime;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseLesson() {
        return courseLesson;
    }

    public void setCourseLesson(Integer courseLesson) {
        this.courseLesson = courseLesson;
    }
}
