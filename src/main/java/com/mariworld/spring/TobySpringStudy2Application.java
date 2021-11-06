package com.mariworld.spring;

import com.mariworld.spring.propertyeditor.MinMaxAgePropertyEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@SpringBootApplication
public class TobySpringStudy2Application {



	public static void main(String[] args) {



		SpringApplication.run(TobySpringStudy2Application.class, args);
	}

}
