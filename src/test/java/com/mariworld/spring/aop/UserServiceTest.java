package com.mariworld.spring.aop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userServiceTx;

    @Test
    public void beanTest(){
        Assert.assertNotNull(userServiceTx);
        userServiceTx.updateLevels();
    }
}
