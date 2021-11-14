package com.mariworld.spring.propertyeditor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MemberController {

    @Autowired
    MemberValidator memberValidator;

    @InitBinder
    public void initPropertyEditor(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(int.class,"age",new MinMaxAgePropertyEditor());
        webDataBinder.setValidator(memberValidator);

    }

    @RequestMapping("/add")
    public Member add(@ModelAttribute Member member){
        log.info("member age: {}" , member.getAge());
        return member;
    }

    @GetMapping("/add/v2")
    public Member add2(@ModelAttribute @Validated Member member){

        return member;
    }
}
