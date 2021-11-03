package com.mariworld.spring.scope;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ServiceLoader;

@SpringBootTest
public class SessionScopeTest {
    @Autowired
    private ApplicationContext act;
    @Autowired
    private ServiceLoader.Provider<LoginUser> loginUserProvider;

    @Test
    public void actTest() throws Exception {
        assertThat(act).isNotNull();
    }


    @Test
    public void loginUserProviderScopeTest() throws Exception {
        LoginUser loginUser = loginUserProvider.get();
        assertThat(loginUser).isNotNull();
    }

}

