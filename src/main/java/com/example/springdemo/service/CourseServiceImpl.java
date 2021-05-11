package com.example.springdemo.service;

import com.example.springdemo.dao.CourseDao;
import com.example.springdemo.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> findAllCourses() {
        List<Course> list = courseDao.listCourses();
        return list;
    }
}
