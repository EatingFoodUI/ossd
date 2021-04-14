package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.domain.*;
import com.lyl.springboot.ossd.service.ServiceImplement.*;
import com.lyl.springboot.ossd.utils.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/ManageCourse")
public class ManageCourse {

    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private VideoServiceImpl videoService;

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private TestServiceImpl testService;

    @Autowired
    private QuestionServiceImpl questionService;

    @Value("${CourseVideo.addr}")
    private String VideoPath;

    @Value("${CourseBook.addr}")
    private String BookPath;

    @RequestMapping("/createCourse")
    public String createCourse(@RequestParam("course") Course course){
        try{
            String courseId = GenerateId.generateId();
            course.setCourseId(courseId);
            courseService.save(course);
            return "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    @RequestMapping("/modifyCourseInfo")
    public String modifyCourseInfo(@RequestParam("course") Course course){
        try{
            if(course.getCourseType() != null){
                courseService.modifyCourseTypeById(course.getCourseType(), course.getCourseId());
            }
            if(course.getCourseDes() != null){
                courseService.modifyCourseDesById(course.getCourseDes(), course.getCourseId());
            }
            if(course.getCourseIndex() != null){
                courseService.modifyCourseIndexById(course.getCourseIndex(), course.getCourseId());
            }
            if(course.getPreStudy() != null){
                courseService.modifyCoursePreStudyById(course.getPreStudy(), course.getCourseId());
            }
            if(course.getCourseBook() != null){
                courseService.modifyCourseBookById(course.getCourseBook(),course.getCourseId());
            }
            return "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    @RequestMapping("/updateCourseVideo")
    public String updateCourseVideo(@RequestParam("videoInfo")Video video,
                                    @RequestParam("video")MultipartFile multipartFile){
        try{
            File file = new File(VideoPath + video.getVideoName());
            multipartFile.transferTo(file);

            video.setVideoId(GenerateId.generateId());
            video.setVideoAdd(VideoPath+video.getVideoName());

            videoService.save(video);

            return "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    @RequestMapping("/updateCourseBook")
    public String updateCourseBook(@RequestParam("BookInfo")Book book,
                                   @RequestParam("Book")MultipartFile multipartFile){
        try{
            File file = new File(BookPath + book.getBookName());
            multipartFile.transferTo(file);

            book.setBookId(GenerateId.generateId());
            book.setBookAdd(BookPath+book.getBookName());

            bookService.save(book);

            return "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    @RequestMapping("/updateCourseTest")
    public String updateCourseTest(@RequestParam("Test")Test test){
        try{
            test.setCourseId(GenerateId.generateId());
            testService.save(test);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    @RequestMapping("/updateCourseQue")
    public String updateCourseQue(@RequestParam("Que") Question question){
        try{
            question.setQueId(GenerateId.generateId());
            questionService.save(question);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}
