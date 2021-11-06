package com.mariworld.spring.propertyeditor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MemberController {

    @InitBinder
    public void initPropertyEditor(WebDataBinder webDataBinder){
        //webDataBinder.registerCustomEditor(int.class,"age",new MinMaxAgePropertyEditor());
        webDataBinder.registerCustomEditor(int.class, new MinMaxAgePropertyEditor());
    }

    @RequestMapping("/add")
    public Member add(@ModelAttribute Member member){
        log.info("member age: {}" , member.getAge());
        return member;
    }
}
