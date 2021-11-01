package com.mariworld.spring.scope;

import org.springframework.stereotype.Component;

@Component
public interface ScopeBeanFactory {

     SingletonScopeBean getSingletonScopeBean();
}
