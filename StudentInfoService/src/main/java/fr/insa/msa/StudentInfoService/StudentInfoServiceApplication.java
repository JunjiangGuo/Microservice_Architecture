package fr.insa.msa.StudentInfoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StudentInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentInfoServiceApplication.class, args);
	}

}
