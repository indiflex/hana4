package com.hana4.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.hana4.demo.entity.User;
import com.hana4.demo.repository.UserRepository;

@Component
@Profile("test")
public class InitialDataLoader implements ApplicationRunner {
	private final UserRepository repository;

	public InitialDataLoader(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIII****");
		// Optional<User> user10 = repository.findByName("AA10");
		// if (user10.isPresent()) {
		// 	return;
		// }

		repository.initialize();

		for (short s = 10; s < 13; s++) {
			repository.addUser(new User("AA" + s, s));
		}
	}
}
