package com.mariworld.spring.aop;

import com.mariworld.spring.serviceabstraction.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

    @Override
    public void add(User user) {
        System.out.println("add user.... "+ user.getName());
    }

    @Override
    public void updateLevels() {
        System.out.println("update users.............");
    }
}
