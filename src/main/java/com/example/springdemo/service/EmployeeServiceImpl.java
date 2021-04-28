package com.example.springdemo.service;

import com.example.springdemo.dao.EmployeeDAO;
import com.example.springdemo.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public void addEmployee(Employee e) {
        this.employeeDAO.addEmployee(e);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee e) {
        this.employeeDAO.updateEmployee(e);
    }

    @Override
    @Transactional
    public List<Employee> listEmployees() {
        return this.employeeDAO.listEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return this.employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void removeEmployee(int id) {
        this.employeeDAO.removeEmployee(id);
    }
}
