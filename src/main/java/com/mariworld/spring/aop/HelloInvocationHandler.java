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

    //프록시 패턴 : 위임 & 부가기능을 제공한다
    //실제 메소드는 위임하고 있는 안의 인터페이스가 하고
    //나는 해당 메소드 invoke할때의 부가기능만 제공한다
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
