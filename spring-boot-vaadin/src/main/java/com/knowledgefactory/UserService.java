package com.knowledgefactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	

	public List<User> findAll() {
		User user1 = new User(1, "KnowledgeFactory", "KnowledgeFactory@gmail.com");
		User user2 = new User(2, "KnowledgeFactoryduplicate", "KnowledgeFactoryduplicate@gmail.com");

		List<User> users = new ArrayList<>();
		users.add(user2);
		users.add(user1);
		return users;

	}

}
