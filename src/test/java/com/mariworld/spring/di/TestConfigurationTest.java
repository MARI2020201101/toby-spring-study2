package com.mariworld.spring.di;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TestConfigurationTest {

   /* @Autowired
    private TestConfiguration configuration;*/

    @Autowired
    private ApplicationContext ac;


    @Test
    public void acTest(){
        assertThat(ac).isNotNull();
    }

    @Test
    public void beanTest(){
       Hello hello1 = ac.getBean("hello", Hello.class);
       //Hello hello2 = configuration.hello();

       //assertThat(hello1).isEqualTo(hello2);
    }

    @Test
    public void beanTest2(){
        TestConfiguration configuration= new TestConfiguration();
        Hello hello1 = configuration.hello();
        Hello hello2 = configuration.hello();
        Hello hello3 = ac.getBean("hello", Hello.class);

        assertThat(hello1).isEqualTo(hello2);
        assertThat(hello1).isEqualTo(hello3);
    }


}
