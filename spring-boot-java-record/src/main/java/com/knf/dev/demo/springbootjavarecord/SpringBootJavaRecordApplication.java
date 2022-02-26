package com.knf.dev.demo.springbootjavarecord;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.knf.dev.demo.springbootjavarecord.entity.User;
import com.knf.dev.demo.springbootjavarecord.repsitory.UserRepository;

@SpringBootApplication
public class SpringBootJavaRecordApplication 
        implements CommandLineRunner {

	@Autowired
	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.
		   run(SpringBootJavaRecordApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
        //Inserting dummy data
		User user1 = 
				new User("dummy user", 
						 "dummy lastname", "dummy@gmail.com");
		User user2 = 
				new User("dummy user 2", 
						 "dummy lastname 2", "dummy@gmail2.com");
		List<User> users = new ArrayList<User>();
		users.add(user2);
		users.add(user1);
		repository.saveAll(users);

	}
}
