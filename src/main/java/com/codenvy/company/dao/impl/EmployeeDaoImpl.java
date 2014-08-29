package com.codenvy.company.dao.impl;

import com.codenvy.company.dao.EmployeeDao;
import com.codenvy.company.model.Employee;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 23.08.2014.
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
    public void addEmployee(Employee employee){
        getHibernateTemplate().save(employee);
    }

    public void deleteEmployee(Employee employee) {
        getHibernateTemplate().delete(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        getHibernateTemplate().update(employee);
    }

    public List<Employee> findAllEmployee(int n){
        if (n != 0) {
            Query tmp = getSession().createQuery("from Employee");

            int first = 0;

            if (first != 0)
                tmp.setFirstResult(first);
            if (n != 0)
                tmp.setMaxResults(n);

            return (List<Employee>) tmp.list();
        }
        else
            return getHibernateTemplate().find("from Employee");
    }
}
