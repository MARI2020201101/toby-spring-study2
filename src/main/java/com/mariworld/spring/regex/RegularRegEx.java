package com.mariworld.spring.regex;

import java.util.regex.Pattern;

public class RegularRegEx {

    public static boolean isValid(String string){

        return string.matches("(19|20)\\d{12}");
    }
}
