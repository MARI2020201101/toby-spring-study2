package com.mariworld.spring.aop;

import com.mariworld.spring.serviceabstraction.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserServiceTx implements UserService {
    @Autowired
    private UserService userServiceImpl;

    @Override
    public void add(User user) {
        System.out.println("transaction~~~~~~~~~");
        userServiceImpl.add(user);
    }

    @Override
    public void updateLevels() {
        System.out.println("transaction~~~~~~~");
        userServiceImpl.updateLevels();
    }
}
