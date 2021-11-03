package com.mariworld.spring.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ServiceLoader;

@Component
public class LoginUserProviderImpl implements ServiceLoader.Provider<LoginUser> {

    @Autowired
    private LoginUser loginUser;
    @Override
    public Class<? extends LoginUser> type() {
        return LoginUser.class;
    }

    @Override
    public LoginUser get() {
        return loginUser;
    }
}
