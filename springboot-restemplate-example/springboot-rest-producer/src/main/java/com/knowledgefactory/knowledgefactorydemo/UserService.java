package com.knowledgefactory.knowledgefactorydemo;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public Map<Integer, User> getUser() {

		Map<Integer, User> list = User.userFactory();

		return list;

	}

	public Map<Integer, User> deleteuser(Integer UserId) {

		Map<Integer, User> list = User.userFactory();
		list.remove(UserId);

		return list;
	}

}
