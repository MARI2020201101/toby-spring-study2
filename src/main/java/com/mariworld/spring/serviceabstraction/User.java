package com.mariworld.spring.serviceabstraction;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String name;
    private String password;
    private Level level;
    private int login;
    private int recommend;

    public void upgradeLevel(){
        this.setLevel(level.next());
    }

}
