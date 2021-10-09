package com.mariworld.spring.aop;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectionTest {
    @Test
    public void testReflection() throws Exception {
        String spring = "spring";

        Method lengthMethod = String.class.getDeclaredMethod("length" );
        Assert.assertEquals(6,(int)lengthMethod.invoke(spring));

        Method charAtMethod = String.class.getMethod("charAt",int.class);
        Assert.assertEquals('s',charAtMethod.invoke(spring,0));
    }

    @Test
    public void testHelloReflection() throws Exception {
        Hello hello = new HelloImpl();

        Hello target = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                new HelloInvocationHandler(hello));

        System.out.println(target.hello("spring"));
    }


}
