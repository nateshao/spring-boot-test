package com.nateshao;

import com.nateshao.config.DemoConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootApplicationTests {

    @Value("${user.username}")
    private String username;
    @Value("${user.password}")
    private String password;
    @Value("${user.age}")
    private String age;

    @Autowired
    private DemoConfig demoConfig;

    @Test
    void testUsername() {
        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
    }

    @Test
    void testDemoConfig() {
        System.out.println(demoConfig);
    }
}
