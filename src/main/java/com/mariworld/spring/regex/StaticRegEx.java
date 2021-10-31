package com.mariworld.spring.regex;

import java.util.regex.Pattern;

public class StaticRegEx {

    private static final Pattern yyyyMMddHHmmss = Pattern.compile("(19|20)\\d{12}");

    public static boolean isValid(String string){
        return yyyyMMddHHmmss.matcher(string).matches();
    }
}
