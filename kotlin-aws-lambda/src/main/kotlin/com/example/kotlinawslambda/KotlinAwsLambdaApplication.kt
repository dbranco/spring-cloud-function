package com.example.kotlinawslambda

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotlinAwsLambdaApplication {

	@Bean
	fun greet(): (String) -> String {
		return { input -> "Hello from kotlin $input" }
	}

}

fun main(args: Array<String>) {
	runApplication<KotlinAwsLambdaApplication>(*args)
}
