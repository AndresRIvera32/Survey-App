package com.aws.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aws.spring.lib.SecurityConfiguration;
import com.aws.spring.lib.SwaggerConfig;


@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@Import({SwaggerConfig.class, SecurityConfiguration.class})
public class SurveyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyAppApplication.class, args);
	}

}
