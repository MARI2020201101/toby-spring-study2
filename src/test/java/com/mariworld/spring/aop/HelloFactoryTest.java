package com.mariworld.spring.aop;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class HelloFactoryTest {

    @Autowired
    ApplicationContext act;
    @Test
    public void testHelloFactory() throws Exception {
        assertNotNull(act);
        String[] beans = act.getBeanDefinitionNames();
        for (String b :beans ) {
            System.out.println("------------------------------------------");
            System.out.println(b);
        }
        Object hello = act.getBean("helloFactoryBean");
        System.out.println(hello.getClass());
    }

    @Test
    public void testHelloFactory2() throws Exception {
        Hello hello = (Hello) act.getBean("helloFactoryBean");
        System.out.println(hello.toString());
    }


}
