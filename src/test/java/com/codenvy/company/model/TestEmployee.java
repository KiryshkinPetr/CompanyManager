package com.codenvy.company.model;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Asus on 28.08.2014.
 */
public class TestEmployee {

    private int hourRate = 12;
    Employee employee1;
    Employee employee2;

    @BeforeClass
    public void initEmployee(){
        employee1 = new Employee("First Name", "First Name", 23);
        employee2 = new Employee("First Name", "First Name", 23, hourRate);
    }

    @Test
    public void testGetSalary(){
        Assert.assertEquals(3000.00,  employee1.getSalary());
    }

    @Test
    public void testGetSalaryHourRate(){
        Assert.assertEquals(20.8 * 8 * hourRate,  employee2.getSalary());
    }
}
