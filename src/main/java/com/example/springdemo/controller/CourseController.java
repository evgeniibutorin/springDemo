package com.example.springdemo.controller;

import com.example.springdemo.model.Course;
import com.example.springdemo.service.CourseService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

///WEB-INF/view
    @GetMapping(value = "/course")
    public String getCourses(ModelMap courseModel){
//        List<Course> list = courseService.findAllCourses();
//        for (Course c:list){
//            System.out.println(c.getCourseName());
//        }
        System.out.println("I am working");
        return "home";
    }
}
