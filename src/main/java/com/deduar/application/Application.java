package com.deduar.application;

import java.util.stream.Stream;

import com.deduar.application.entities.User;
import com.deduar.application.repositories.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("Jhon","Julie","Jennifer","Helen","Rachel").forEach(name -> {
				User user = new User(name, name.toLowerCase()+"@gmail.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}

}
