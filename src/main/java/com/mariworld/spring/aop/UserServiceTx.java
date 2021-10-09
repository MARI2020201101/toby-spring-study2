package com.mariworld.spring.aop;

import com.mariworld.spring.serviceabstraction.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public class UserServiceTx implements UserService {

    private UserService userService;

    @Override
    public void add(User user) {
        System.out.println("transaction~~~~~~~~~");
        userService.add(user);
    }

    @Override
    public void updateLevels() {
        System.out.println("transaction~~~~~~~");
        userService.updateLevels();
    }
}
