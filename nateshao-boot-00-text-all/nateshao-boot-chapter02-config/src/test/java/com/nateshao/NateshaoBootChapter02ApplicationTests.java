package com.nateshao;

import com.nateshao.domain.MyProperties;
import com.nateshao.domain.Person;
import com.nateshao.domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NateshaoBootChapter02ApplicationTests {
    @Autowired
    private Person person;
    @Autowired
    private Student student;
    @Autowired
    private MyProperties myProperties;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void studentTest() {
        System.out.println(student);
    }

    @Test
    public void myPropertiesTest() {
        System.out.println(myProperties);
    }

    @Test
    public void iocTest() {
        System.out.println(applicationContext.containsBean("myService"));
    }
    @Value("${tom.description}")
    private String description;
    @Test
    public void placeholderTest() {
        System.out.println(description);
    }

}
