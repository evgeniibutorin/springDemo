package com.example.springdemo.dao;

import com.example.springdemo.model.Employee;
import com.example.springdemo.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO {
    private final SessionFactory sessionFactory;

    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @Transactional
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Student.class);
        List<Student> students = criteria.list();
        return students;
    }
}
