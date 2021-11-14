package com.mariworld.spring.propertyeditor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MemberValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Member.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member m =(Member)target;
        if(m.getName().equals("xxx"))
            errors.rejectValue("name","not supported name");
    }
}
