package com.amos.tenant.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(value = "com.amos.tenant.management")
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
