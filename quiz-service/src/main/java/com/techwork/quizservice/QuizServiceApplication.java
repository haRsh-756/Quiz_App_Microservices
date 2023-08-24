package com.techwork.quizservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author harsh_patel
 * Main application class for the Quiz Service application.
 */
@SpringBootApplication
@EnableFeignClients
public class QuizServiceApplication {

	/**
	 * Main method to start the Quiz Service application.
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}
}
