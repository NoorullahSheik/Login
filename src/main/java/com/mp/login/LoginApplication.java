package com.mp.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableWebSecurity
@ComponentScan(basePackages= {"com.mp"})
public class LoginApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

}
