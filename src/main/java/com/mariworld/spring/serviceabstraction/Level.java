package com.mariworld.spring.serviceabstraction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Level {
    GOLD(3,null),SILVER(2,Level.GOLD), BASIC(1,Level.SILVER);


    private final int value;
    private final Level next;


    public static Level valueOf(int value){
       switch (value){
           case(1): return BASIC;
           case(2): return SILVER;
           case(3): return GOLD;
           default:throw new IllegalArgumentException();
       }
    }

    public Level next(){
        return this.next;
    }

    Level(int value, Level next){
            this.value = value;
            this.next = next;
        }
}
