package com.codenvy;

import com.codenvy.company.bo.EmployeeBo;
import com.codenvy.company.dao.EmployeeDao;
import com.codenvy.company.initialize.Initialize;
import com.codenvy.company.model.Employee;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by Asus on 23.08.2014.
 */
public class EmployeeBean implements Serializable {
    EmployeeBo employeeBo;

    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private int numEmpl;

    private boolean sortAscending = true;

    List<Employee> employeeList;

    @PostConstruct
    public void init(){
        employeeList = employeeBo.findAllEmployee(numEmpl);
    }

    public int getNumEmpl() {
        return numEmpl;
    }

    public void setNumEmpl(int numEmpl) {
        this.numEmpl = numEmpl;
        employeeList = employeeBo.findAllEmployee(numEmpl);
    }

    public void setEmployeeBo(EmployeeBo employeeBo) {
        this.employeeBo = employeeBo;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public List<Employee> sort(int str){

        switch (str){
            case 0:
                employeeList = sortByFirstName();
                break;
            case 1:
                employeeList = sortByLastName();
                break;
            case 2:
                employeeList = sortByAge();
                break;
            case 3:
                employeeList = sortBySalary();
                break;
        }

        return employeeList;
    }

    public List<Employee> sortByFirstName() {
        employeeList = employeeBo.findAllEmployee(numEmpl);
        if(sortAscending){
            //ascending order
            Collections.sort(employeeList, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
            });
            sortAscending = false;
        }else{
            //descending order
            Collections.sort(employeeList, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o2.getFirstName().compareTo(o1.getFirstName());
                }
            });
            sortAscending = true;
        }
        return employeeList;
    }

    public List<Employee> sortByLastName() {

        employeeList = employeeBo.findAllEmployee(numEmpl);
        if(sortAscending){
            //ascending order
            Collections.sort(employeeList, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o1.getLastName().compareTo(o2.getLastName());
                }
            });
            sortAscending = false;
        }else{
            //descending order
            Collections.sort(employeeList, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o2.getLastName().compareTo(o1.getLastName());
                }
            });
            sortAscending = true;
        }
        return employeeList;
    }

    public List<Employee> sortByAge() {

        employeeList = employeeBo.findAllEmployee(numEmpl);
        if(sortAscending){
            //ascending order
            Collections.sort(employeeList, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o1.getAge() - o2.getAge();
                }
            });
            sortAscending = false;
        }else{
            //descending order
            Collections.sort(employeeList, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o2.getAge() - o1.getAge();
                }
            });
            sortAscending = true;
        }
        return employeeList;
    }

    public List<Employee> sortBySalary() {

        employeeList = employeeBo.findAllEmployee(numEmpl);
        if(sortAscending){
            //ascending order
            Collections.sort(employeeList, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return (int)((o1.getSalary() - o2.getSalary())*100);
                }
            });
            sortAscending = false;
        }else{
            //descending order
            Collections.sort(employeeList, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return (int)((o2.getSalary() - o1.getSalary())*100);
                }
            });
            sortAscending = true;
        }
        return employeeList;
    }

    public String initRandomList(){

        clearList();

        for (Employee employee: Initialize.init())
            employeeBo.addEmployee(employee);

        employeeList = employeeBo.findAllEmployee(numEmpl);
        return null;
    }

    public String addEmployee() {
        Employee employee = new Employee();
        employee.setFirstName(getFirstName());
        employee.setLastName(getLastName());
        employee.setAge(getAge());
        employee.setSalary(getSalary());

        employeeBo.addEmployee(employee);

        employeeList = employeeBo.findAllEmployee(numEmpl);

        clearForm();

        return "";
    }

    public String clearList(){
        for (Employee employee: employeeList)
            deleteEmployee(employee);

        return "";
    }

    public String saveAction() {

        //get all existing value but set "editable" to false
        for (Employee employee: employeeList){
            employeeBo.updateEmployee(employee);
            employee.setEditable(false);
        }

        return null;

    }

    public String editAction(Employee employee) {

        employee.setEditable(true);
        return null;
    }

    public String deleteEmployee(Employee employee){
        employeeBo.deleteEmployee(employee);
        employeeList = employeeBo.findAllEmployee(numEmpl);
        return null;
    }

    private void clearForm(){
        setFirstName("");
        setLastName("");
        setAge(0);
        setSalary(0.00);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}