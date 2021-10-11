package com.mariworld.spring.aop;


import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.hamcrest.Matchers.is;

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
    @Test
    public void testHelloReflection2() throws Exception {
        Hello hello = new HelloImpl();

        //클래스로더 , 사용할 인터페이스 , 구현invocationHandler

        Hello target = (Hello) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{Hello.class},
                new HelloInvocationHandler(hello));

        //equals 를 쓰면 동일성 비교를 하기때문에 false가 나온다. hamcret의 assertThat을 사용한다.
        //지금은 라이브러리 다운로드 안되어서 deprecated 사용중
        Assert.assertThat(target.hello("spring"),is("HELLO SPRING"));
    }

}
