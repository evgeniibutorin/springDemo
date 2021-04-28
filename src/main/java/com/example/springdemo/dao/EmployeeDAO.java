package com.example.springdemo.dao;

import com.example.springdemo.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee e);

    void updateEmployee(Employee e);

    List<Employee> listEmployees();

    Employee getEmployeeById(int id);

    void removeEmployee(int id);
}
