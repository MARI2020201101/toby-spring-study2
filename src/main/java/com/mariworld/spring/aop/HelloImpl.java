package com.mariworld.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements Hello{
    @Override
    public String toString() {
        return "Im hello impl";
    }

    @Override
    public String hello(String name) {
        return "hello "+ name;
    }

    @Override
    public String hi(String name) {
        return "hi "+ name;
    }

    @Override
    public String goodAfternoon(String name) {
        return "good Afternoon " +name;
    }
}
