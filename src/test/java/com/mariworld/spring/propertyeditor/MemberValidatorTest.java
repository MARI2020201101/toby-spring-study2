package com.mariworld.spring.propertyeditor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.AbstractErrors;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

@SpringBootTest
public class MemberValidatorTest {

    @Autowired
    MemberValidator validator;

}
