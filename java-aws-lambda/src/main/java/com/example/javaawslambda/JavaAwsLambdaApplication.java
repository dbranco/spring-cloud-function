package com.example.javaawslambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class JavaAwsLambdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaAwsLambdaApplication.class, args);
	}

	@Bean
	public Function<String, String> greet() {
		return input -> "Hello from java " + input;
	}

}
