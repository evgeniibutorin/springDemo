package com.example.springdemo.service;

import com.example.springdemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee e);
    void updateEmployee(Employee e);
    List<Employee> listEmployees();
    Employee getEmployeeById(int id);
    void removeEmployee(int id);

}
