package com.mariworld.spring.regex;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegExTest {

    @Test
    public void testRegularRegEx() throws Exception {
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            String yyyyMMddHHmmss = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            boolean valid = RegularRegEx.isValid(yyyyMMddHHmmss);
            System.out.println("valid : " +valid);
        }
        long end = System.nanoTime();
        System.out.println("=================\n"+ (end-start)/1000);
    }
    @Test
    public void testStaticRegEx() throws Exception {
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            String yyyyMMddHHmmss = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            boolean valid = StaticRegEx.isValid(yyyyMMddHHmmss);
            System.out.println("valid : " +valid);
        }
        long end = System.nanoTime();
        System.out.println("=================\n"+ (end-start)/1000);
    }

}
