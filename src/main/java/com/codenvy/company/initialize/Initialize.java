package com.codenvy.company.initialize;


import com.codenvy.company.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Asus on 21.08.2014.
 */
public class Initialize {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
    private static ListFirsNameLastName name = (ListFirsNameLastName)context.getBean("ListFirsNameLastName");

    private static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static ArrayList<Employee> init(){
        Random random = new Random();
        int index = random.nextInt(15) + 1;
        int randImpl;

        for (int i = 0; i < index; i++){
            randImpl = random.nextInt(4 - 2) + 2;
            switch (randImpl) {
                case 2:
                    employees.add(new Employee((String) name.getListFirstName().get(random.nextInt(name.getListFirstName().size())),
                            (String) name.getListLastName().get(random.nextInt(name.getListLastName().size())),
                            random.nextInt(65 - 18) + 18,
                            random.nextInt(100 - 10) + 10));
                    break;
                case 3:
                    employees.add(new Employee((String) name.getListFirstName().get(random.nextInt(name.getListFirstName().size())),
                            (String) name.getListLastName().get(random.nextInt(name.getListLastName().size())),
                            random.nextInt(65 - 18) + 18));
            }
        }
        return employees;
    }



}
