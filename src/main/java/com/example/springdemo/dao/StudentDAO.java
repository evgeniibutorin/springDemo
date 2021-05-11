package com.example.springdemo.dao;

import com.example.springdemo.model.Employee;
import com.example.springdemo.model.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> listStudents();
}
