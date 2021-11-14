package com.mariworld.spring.propertyeditor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MinMaxAgeConverter implements Converter<Integer, Integer> {
    private int min =0;
    private int max =200;

    @Override
    public Integer convert(Integer source) {
        if(source<min)source=min;
        else if (source>max) source=max;
        return source;
    }
}
