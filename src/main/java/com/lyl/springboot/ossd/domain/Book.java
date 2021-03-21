package com.lyl.springboot.ossd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Book {
    @Id
    @Column(nullable = false, unique = true)
    private String bookId;

    @Column(nullable = false, unique = true)
    private String bookName;

    @Column(nullable = false, unique = false)
    private String bookAuthor;

    @Column(nullable = true, unique = false)
    private String bookDes;

    @Column(nullable = false, unique = false)
    private String bookAdd;

    @Column(nullable = false, unique = false)
    private Date bookTime;

    @Column(nullable = false, unique = false)
    private String courseId;

    @Column(nullable = false, unique = false)
    private String courseLesson;

    public Book(){

    }

    public Book(String bookId, String bookName, String bookAuthor, String bookDes, String bookAdd, Date bookTime, String courseId, String courseLesson) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDes = bookDes;
        this.bookAdd = bookAdd;
        this.bookTime = bookTime;
        this.courseId = courseId;
        this.courseLesson = courseLesson;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDes() {
        return bookDes;
    }

    public void setBookDes(String bookDes) {
        this.bookDes = bookDes;
    }

    public String getBookAdd() {
        return bookAdd;
    }

    public void setBookAdd(String bookAdd) {
        this.bookAdd = bookAdd;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseLesson() {
        return courseLesson;
    }

    public void setCourseLesson(String courseLesson) {
        this.courseLesson = courseLesson;
    }
}
