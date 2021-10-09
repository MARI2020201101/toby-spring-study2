package com.mariworld.spring.aop;

import lombok.Setter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Locale;


public class HelloInvocationHandler implements InvocationHandler {

    private Hello target;

    public HelloInvocationHandler(Hello target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object ret = method.invoke(target, args);
        if(ret instanceof String){
            String s = (String) ret;
            return s.toUpperCase();
        }
        return ret;
    }
}
