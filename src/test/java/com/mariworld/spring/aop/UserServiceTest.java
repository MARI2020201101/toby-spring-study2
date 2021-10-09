package com.mariworld.spring.aop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void beanTest(){
        Assert.assertNotNull(userService);
        userService.updateLevels();
    }
}
