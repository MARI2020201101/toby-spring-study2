package com.mariworld.spring.aop;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class HelloFactoryBean implements FactoryBean<Hello> {
    @Autowired
    private Hello target;

    @Override
    public Hello getObject() throws Exception {

        Object helloProxy = Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{Hello.class},
        new HelloInvocationHandler(target));
        return (Hello) helloProxy;
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }
}
