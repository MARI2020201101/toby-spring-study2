package com.mariworld.spring.di;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Printer {

    @Autowired
    private Hello hello;

    public void print(){
        System.out.println("Print "+ hello.getName());
    }
}
