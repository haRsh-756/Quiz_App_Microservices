package com.techwork.apigateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author harsh_patel
 * The main class for the API Gateway application.
 */
@SpringBootApplication
public class ApiGatewayApplication {

	/**
	 * The entry point for running the API Gateway application.
	 * @param args The command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}
