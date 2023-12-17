package fr.insa.msa.studentEvalService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StudentEvalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentEvalServiceApplication.class, args);
	}

}
