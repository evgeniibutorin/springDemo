package com.example.springdemo.dao;

import com.example.springdemo.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addEmployee(Employee e) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(e);
        logger.info("Employee saved successfully, Employee Details="+e);
    }

    @Override
    public void updateEmployee(Employee e) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(e);
        logger.info("Employee updated successfully, Employee Details="+e);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> listEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeesList = session.createQuery("from Employee ").list();
        for(Employee e : employeesList){
            logger.info("Employee List::"+e);
        }
        return employeesList;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee e = (Employee) session.load(Employee.class, new Integer(id));
        logger.info("Employee loaded successfully, Employee details="+e);
        return e;
    }

    @Override
    public void removeEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee e = (Employee) session.load(Employee.class, new Integer(id));
        if(null != e){
            session.delete(e);
        }
        logger.info("Employee deleted successfully, Employee details="+e);
    }



}
