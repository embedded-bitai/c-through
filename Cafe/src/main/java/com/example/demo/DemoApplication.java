package com.example.demo;

import com.example.demo.nativeinterface.array.ArrayReturnTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ArrayReturnTest arrayReturnTest = new ArrayReturnTest();
		SpringApplication.run(DemoApplication.class, args);
	}

}
