package com.mariworld.spring.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "session")
public class LoginUser {
    private String name;

}
