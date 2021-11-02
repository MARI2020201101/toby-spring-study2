package com.mariworld.spring.scope;

import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactoryConfig {

    @Bean
    public ObjectFactoryCreatingFactoryBean scopeBeanFactory(){
        ObjectFactoryCreatingFactoryBean obj = new ObjectFactoryCreatingFactoryBean();
        obj.setTargetBeanName("singletonScopeBean");
        return obj;
    }



}


