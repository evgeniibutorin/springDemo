package com.example.springdemo.dao;

import com.example.springdemo.model.Course;
import com.example.springdemo.model.Student;

import java.util.List;

public interface CourseDao {
    List<Course> listCourses();
}
