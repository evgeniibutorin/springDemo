package com.example.springdemo.dao;

import com.example.springdemo.model.Course;
import com.example.springdemo.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao{
    private final SessionFactory sessionFactory;

    public CourseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Course> listCourses() {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Student.class);
        List<Course> courses = criteria.list();
        return courses;
    }
}
