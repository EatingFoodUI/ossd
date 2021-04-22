package com.lyl.springboot.ossd.controller;

import com.lyl.springboot.ossd.domain.*;
import com.lyl.springboot.ossd.service.ServiceImplement.*;
import com.lyl.springboot.ossd.utils.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    // 老师创建课程
    @RequestMapping("/createCourse")
    public Object createCourse(String courseName, String courseType,
                               String courseDes, String courseBook,
                               String TeacherId){
        try{
            Course course = new Course();
            String courseId = GenerateId.generateId();
            // 不需要判断是否有同名课程
            course.setCourseId(courseId);
            course.setCourseName(courseName);
            course.setCourseType(courseType);
            course.setCourseDes(courseDes);
            course.setCourseBook(courseBook);
            course.setTeacherId(TeacherId);
            course.setCourseVertify("0");
            courseService.save(course);
            // 添加成功
            return "{'status':1}";
        }catch (Exception e){
            e.printStackTrace();
        }
        // 添加失败
        return "{'status':0}";
    }

    // 通过课程id修改课程信息
    @RequestMapping("/modifyCourseInfo")
    public Object modifyCourseInfo(String courseId, String courseType,
                                   String courseDes, String courseBook){
        try {
            Course course = courseService.findByCourseId(courseId);
            if(course == null){
                return "{'status':0}";
            }
            if(!courseType.equals("")){
                courseService.modifyCourseTypeById(courseType,courseId);
            }
            if(!courseDes.equals("")){
                courseService.modifyCourseDesById(courseDes,courseId);
            }
            if(!courseBook.equals("")){
                courseService.modifyCourseBookById(courseBook,courseId);
            }
            return "{'status':1}";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{'status':0}";
    }

    // 通过课程id删除课程信息
    @RequestMapping("/deleteCourseInfo")
    public Object modifyCourseInfo(String courseId){
        try {
            Course course = courseService.findByCourseId(courseId);
            if(course == null){
                return "{'status':0}";
            }
            courseService.deleteById(courseId);
            return "{'status':1}";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{'status':0}";
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

    // 通过是否审核查找课程
    @RequestMapping("/ViewCourseByVertify")
    public Object updateCourseQue(@RequestParam("Vertify") String vertify,
                                  @RequestParam("pagenum") int pagenum,
                                  @RequestParam("pageSize") int pageSize){
        try{
            Pageable pageable = PageRequest.of(pagenum-1, pageSize);
            Page<Course> page = courseService.findByVertify(vertify,pageable);
            return page;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    // 审核课程
    @RequestMapping("/VertityCourseById")
    public String updateCourseQue(@RequestParam("CourseId") String courseId){
        try{
            if(courseId == null){
                return "0";
            }
            Course course = courseService.findByCourseId(courseId);
            if(course == null){
                return "1";
            }
            course.setCourseVertify("1");
            courseService.save(course);
            return "2";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }
}
