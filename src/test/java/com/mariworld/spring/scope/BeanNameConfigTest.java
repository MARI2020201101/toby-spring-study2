package com.mariworld.spring.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class BeanNameConfigTest {

    @Autowired
    ApplicationContext act;

    @Autowired
    BeanName abc;

    @Autowired
    BeanName ABC;

    @Autowired
    GenericApplicationContext gac;

    @Test
    public void beanNameTest() throws Exception {
        BeanName bean1 = act.getBean("ABC", BeanName.class);
        BeanName bean2 = act.getBean("abc", BeanName.class);
        BeanName bean3 = act.getBean("가나다", BeanName.class);

        assertThat(bean1).isEqualTo(bean2);
        assertThat(bean1).isEqualTo(bean3);
        assertThat(bean2).isEqualTo(bean3);
    }

    @Test
    public void beanNameTest2() throws Exception {
        assertThat(abc).isEqualTo(ABC);
    }

    @Test
    public void beanDefinitionTest() throws Exception {
        String[] names = gac.getBeanDefinitionNames();
        for (String name : names) {
            int role = gac.getBeanDefinition(name).getRole();
            System.out.println(role + "  : " + name );
        }
    }


}

