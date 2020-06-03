package com.lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.lesson"})
//@ComponentScan(nameGenerator = FQCNGenerator.class)
public class SougouApplication {

	public static void main(String[] args) {
		SpringApplication.run(SougouApplication.class, args);
	}

}
