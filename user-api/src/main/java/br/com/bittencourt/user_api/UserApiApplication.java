package br.com.bittencourt.user_api;

import br.com.bittencourt.user_api.domain.User;
import br.com.bittencourt.user_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@RequiredArgsConstructor
@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {


	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(List.of(
				new User(null,"Pedro", "pedro@gmail.com", "12345", 12.20),
				new User(null,"Maria", "maria@gmail.com", "12345", 14.20),
				new User(null,"Gustavo", "gustavo@gmail.com", "12345", 16.20)
		));
	}
}
