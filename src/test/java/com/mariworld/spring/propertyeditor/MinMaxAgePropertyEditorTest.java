package com.mariworld.spring.propertyeditor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MinMaxAgePropertyEditorTest {

    @Test
    public void setValueTest() throws Exception {
        MinMaxAgePropertyEditor editor = new MinMaxAgePropertyEditor();
        editor.setAsText("300");
        String text = editor.getAsText();
        assertEquals("200",text);
    }

}
