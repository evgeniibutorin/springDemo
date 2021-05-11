package com.example.springdemo.service;

import com.example.springdemo.model.Course;
import com.example.springdemo.model.Student;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();
}
