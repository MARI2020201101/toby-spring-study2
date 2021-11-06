package com.mariworld.spring.propertyeditor;

import java.beans.PropertyEditorSupport;

public class MinMaxAgePropertyEditor extends PropertyEditorSupport {

    private int max = 200;
    private int min = 0;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        int target = Integer.parseInt(text);
        if(target>max) target=max;
        else if(target<min) target=min;
        this.setValue(String.valueOf(target));
    }

    @Override
    public String getAsText() {
       return String.valueOf(this.getValue());
    }
}
