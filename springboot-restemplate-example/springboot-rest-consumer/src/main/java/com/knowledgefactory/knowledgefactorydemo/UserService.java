package com.knowledgefactory.knowledgefactorydemo;

import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	public Map<Integer, User> getUser() {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map<Integer, User>> response = restTemplate.exchange("http://localhost:9094/getUser",
				HttpMethod.GET, null, new ParameterizedTypeReference<Map<Integer, User>>() {
				});
		Map<Integer, User> users = response.getBody();

		return users;

	}

	public String deleteuser(Integer UserId) throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		Key key = new Key();
		key.setKey(UserId);
		String url = "http://localhost:9094/deleteUser";
		String commonResult = restTemplate.postForObject(url, key, String.class);

		return commonResult;
	}

}
