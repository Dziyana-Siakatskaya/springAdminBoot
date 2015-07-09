package com.epam.edu.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.epam.edu.student.config.Config;

@Configuration
@Import({ Config.class })
public class SpringBatchAdmin extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchAdmin.class, args);
			}

	@Autowired 
	private ApplicationContext applicationContext;
	


	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(Config.class);
	}

}