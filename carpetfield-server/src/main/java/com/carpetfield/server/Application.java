package com.carpetfield.server;

import com.carpetfield.server.domain.auth.Role;
import com.carpetfield.server.domain.auth.User;
import com.carpetfield.server.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by selcukb on 09.03.2017.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner loadTestData(UserRepository userRepo)
	{
		return (args) -> {
			userRepo.save(new User("selcuk.bozdag@gmail.com", "12345", Role.USER));
			userRepo.save(new User("albayrakalican@gmail.com", "12345", Role.USER));
			userRepo.save(new User("skiranoglu@gmail.com", "12345", Role.USER));
		};
	}
}
