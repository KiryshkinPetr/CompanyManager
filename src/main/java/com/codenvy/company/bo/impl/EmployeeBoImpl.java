package com.codenvy.company.bo.impl;

import com.codenvy.company.bo.EmployeeBo;
import com.codenvy.company.dao.EmployeeDao;
import com.codenvy.company.model.Employee;

import java.util.List;

/**
 * Created by Asus on 23.08.2014.
 */
public class EmployeeBoImpl implements EmployeeBo{

    EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public List<Employee> findAllEmployee(int n) {
        return employeeDao.findAllEmployee(n);
    }

}
