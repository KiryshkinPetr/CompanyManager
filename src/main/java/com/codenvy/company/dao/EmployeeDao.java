package com.codenvy.company.dao;

import com.codenvy.company.model.Employee;

import java.util.List;

/**
 * Created by Asus on 23.08.2014.
 */
public interface EmployeeDao {

    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> findAllEmployee(int n);

}
