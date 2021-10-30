package com.mariworld.spring.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ServiceLoader;

@Component
public class ProviderImpl implements ServiceLoader.Provider<SingletonScopeBean> {

    @Autowired
    private SingletonScopeBean singletonScopeBean;
    @Override
    public Class<? extends SingletonScopeBean> type() {
        return SingletonScopeBean.class;
    }

    @Override
    public SingletonScopeBean get() {
        return singletonScopeBean;
    }
}
