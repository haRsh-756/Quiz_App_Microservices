package com.techwork.serviceregistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author harsh_patel
 * The main class for the Service Registry application.
 */
@SpringBootApplication
@EnableEurekaServer // Enable Eureka Server functionality
public class ServiceRegistryApplication {

	/**
	 * The entry point for running the Service Registry application.
	 * @param args The command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}
}
