package com.mariworld.spring.aspectj;

import com.mariworld.spring.aop.Hello;
import com.mariworld.spring.aop.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloAspectTest {

    @Autowired
    UserService userServiceImpl;
    @Test
    public void helloAspectJTest() throws Exception {
        userServiceImpl.updateLevels();
    }

}
