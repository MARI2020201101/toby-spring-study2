package com.mariworld.spring.serviceabstraction;

import lombok.Data;

@Data
public class User {

    private String id;
    private String name;
    private String passwd;
    private Level level;
    private int login;
    private int recommend;

    enum Level{
        BASIC(1),SILVER(2),GOLD(3);

        private final int value;
        Level(int value){
            this.value = value;
        }
    }
}
