package com.example.springdemo.dao;

import com.example.springdemo.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
    //Как появляется sessionFactory она тут нулевая.
    private final SessionFactory sessionFactory;

    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEmployee(Employee e) {
        Session session = this.sessionFactory.getCurrentSession();
        //persist(Object) — преобразует объект из transient в persistent,
        // то есть присоединяет к сессии и сохраняет в БД.
        // Однако, если мы присвоим значение полю Id объекта,
        // то получим PersistentObjectException — Hibernate посчитает,
        // что объект detached, т. е. существует в БД.
        // При сохранении метод persist() сразу выполняет insert,
        // не делая select.
        session.persist(e);
        logger.info("Employee saved successfully, Employee Details="+e);
    }

    @Override
    public void updateEmployee(Employee e) {
        Session session = this.sessionFactory.getCurrentSession();
        //update(Object) — обновляет объект в БД, преобразуя его в persistent (Object в статусе detached)
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
        //Вместо метода session.get() можно использовать session.load().
        // Метод session.load() возвращает так называемый proxy-object.
        // Proxy-object — это объект-посредник, через который мы можем
        // взаимодействовать с реальным объектом в БД. Он расширяет
        // функционал объекта-сущности. Взаимодействие с proxy-object
        // полностью аналогично взаимодействию с объектом-сущностью.
        // Proxy-object отличается от объекта-сущности тем, что при создании
        // proxy-object не выполняется ни одного запроса к БД,
        // т. е. Hibernate просто верит нам, что объект с данным Id существует в БД.
        // Однако первый вызванный get или set у proxy-object сразу инициирует запрос select,
        // и если объекта с данным Id нет в базе, то мы получим ObjectNotFoundException.
        // Основное предназначение proxy-object — реализация отложенной загрузки.
        //get(Object.class, id) — получает из БД объект класса-сущности с определённым Id в статусе persistent
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
