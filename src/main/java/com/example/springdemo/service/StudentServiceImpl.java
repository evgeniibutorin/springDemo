package com.example.springdemo.service;

import com.example.springdemo.dao.StudentDAO;
import com.example.springdemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAllStudent() {
        return studentDAO.listStudents();
    }
}
