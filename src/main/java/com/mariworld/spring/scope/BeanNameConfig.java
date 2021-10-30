package com.mariworld.spring.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanNameConfig {

    @Bean(name={"abc","ABC","가나다"})
    public BeanName beanName(){
        return new BeanName();
    }
}
class BeanName{

}