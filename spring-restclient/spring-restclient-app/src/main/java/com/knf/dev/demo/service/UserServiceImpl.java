package com.knf.dev.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knf.dev.demo.model.User;
import com.knf.dev.demo.response.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final RestClient restClient;

    public UserServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public User createUser(User user) {

        ResponseEntity<User> responseEntity = restClient.post()
                .accept(MediaType.APPLICATION_JSON)
                .body(user)
                .retrieve()
                .toEntity(User.class);

        logger.info("User: " + responseEntity.getBody());

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            logger.info("Created:  " + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }

    @Override
    public User updateUser(User user, Long id) {

        ResponseEntity<User> responseEntity = restClient.put()
                .uri("/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(user)
                .retrieve()
                .toEntity(User.class);

        logger.info("User: " + responseEntity.getBody());

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            logger.info("Updated: " + responseEntity.getStatusCode());
        }

        return responseEntity.getBody();
    }

    @Override
    public User findById(Long id) {
        User user = restClient.get()
                .uri("/{id}",id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        (req, res) -> {
                            logger.error("Failed to get User: " + res.getStatusText());
                            logger.error("Failed to get User:" + res.getStatusCode());
                        }
                )
                .onStatus(HttpStatusCode::is5xxServerError,
                        (req, res) -> {
                            //TODO
                        })
                .body(User.class);

        logger.info("User: " + user);

        return user;
    }

    @Override
    public User findByIdWithExchangeMethod(Long id) {

        User user = restClient.get()
                .uri("/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    if (response.getStatusCode().is4xxClientError()) {
                        logger.error("Failed to get User: " + response.getStatusText());
                        logger.error("Failed to get User:" + response.getStatusCode());
                        return null;
                    }
                    else {
                        ObjectMapper mapper = new ObjectMapper();
                        User _user = mapper.readValue(response.getBody(), User.class);
                        logger.error("User: " + _user);
                        return _user;
                    }
                });
        return user;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = restClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
        logger.info("List of users: " + users);
        return users;
    }

    @Override
    public List<User> getAllUsersAsResponseEntity() {

        ResponseEntity<List> responseEntity = restClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(List.class);

        logger.info("List of users: " + responseEntity.getBody());

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            logger.info("Fetched: " + responseEntity.getStatusCode());
        }

        return responseEntity.getBody();
    }


    @Override
    public void deleteUser(Long id) {

        ResponseEntity response = restClient.delete()
                .uri("/{id}",id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        (req, res) -> {
                            logger.error("Couldn't delete:" + res.getStatusText());
                            logger.error("Couldn't delete:" + res.getStatusCode());
                            ObjectMapper mapper = new ObjectMapper();
                            ErrorMessage message = mapper.readValue(res.getBody(),
                                    ErrorMessage.class);
                            logger.error("Couldn't delete:" + message);
                        }
                )
                .onStatus(HttpStatusCode::is5xxServerError,
                (req, res) -> {
                    //TODO
                }
        )
                .toBodilessEntity();

        if (response.getStatusCode().is2xxSuccessful())
            logger.info("Deleted with status " +
                    response.getStatusCode());
    }
}
