package com.mariworld.spring.aop;

import com.mariworld.spring.serviceabstraction.User;
import com.mariworld.spring.serviceabstraction.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
