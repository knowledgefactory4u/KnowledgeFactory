package com.knowledgefactory.knowledgefactorydemo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.knowledgefactory.Entity.User;
import com.knowledgefactory.Repository.UserRepository;

@EnableJpaRepositories(basePackages = "com.knowledgefactory.Repository")
@SpringBootApplication
@ComponentScan({ "com" })
@EntityScan("com.knowledgefactory.Entity")
public class KnowledgefactorydemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;
	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(KnowledgefactorydemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("DATASOURCE = " + dataSource.getClass());
		repository.save(new User("Knf"));
		repository.save(new User("sibin"));

	}

}
