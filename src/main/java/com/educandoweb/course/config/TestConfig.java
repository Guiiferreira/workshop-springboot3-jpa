package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired //spring resolve a depedencia 
	private UserRepository userRepository;//depedencia

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Gui Ferreira", "gui@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Marta pereira", "marta@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); //instaciar o banco de dados
		
	}
	
	
	

}