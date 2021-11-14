package com.mariworld.spring.propertyeditor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MinMaxAgePropertyEditorTest {

    @Autowired
    MinMaxAgeConverter minMaxAgeConverter;

    @Test
    public void setValueTest() throws Exception {
        MinMaxAgePropertyEditor editor = new MinMaxAgePropertyEditor();
        editor.setAsText("300");
        String text = editor.getAsText();
        assertEquals("200",text);
    }

    @Test
    public void minMaxAgeConverterTest() throws Exception {
        Integer result = minMaxAgeConverter.convert(300);
        assertEquals(200,result);
    }

}
