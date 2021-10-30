package com.mariworld.spring.scope;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssertFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ServiceLoader;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class scopeBeanTest {

    @Autowired
    private ApplicationContext act;
    @Autowired
    private ObjectFactory<SingletonScopeBean> objectFactory;


    @Autowired
    ServiceLoader.Provider<SingletonScopeBean> provider;

    @Test
    public void ScopeTest() throws Exception {
        SingletonScopeBean bean1 = act.getBean("singletonScopeBean", SingletonScopeBean.class);
        SingletonScopeBean bean2 = act.getBean("singletonScopeBean", SingletonScopeBean.class);
        assertThat(bean1).isEqualTo(bean2);
        Set<Object> set = new HashSet<>();
        set.add(bean1);
        set.add(bean2);
        assertThat(set.size()).isEqualTo(1);
    }

    @Test
    public void ScopeTest2() throws Exception {
        ProtoScopeBean bean1 = act.getBean("protoScopeBean", ProtoScopeBean.class);
        ProtoScopeBean bean2 = act.getBean("protoScopeBean", ProtoScopeBean.class);
        Set<Object> set = new HashSet<>();
        set.add(bean1);
        set.add(bean2);
        assertThat(set.size()).isEqualTo(2);
    }

    @Test
    public void ScopeObjectFactoryBeanTest() throws Exception {
        SingletonScopeBean bean = objectFactory.getObject();
        assertThat(bean).isNotNull();
    }


    @Test
    public void providerTest() throws Exception {
        SingletonScopeBean bean = provider.get();
        assertThat(bean).isNotNull();
    }

    @Test
    public void providerTest2() throws Exception {
        SingletonScopeBean bean1 = provider.get();
        SingletonScopeBean bean2 = provider.get();
        assertThat(bean1).isEqualTo(bean2);
        Set<Object> set = new HashSet<>();
        set.add(bean1);
        set.add(bean2);
        assertThat(set.size()).isEqualTo(1);
    }
}
