package com.knf.dev.demo.springbootfreemarkerjpacrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.knf.dev.demo.springbootfreemarkerjpacrud.exception.RecordNotFoundException;
import com.knf.dev.demo.springbootfreemarkerjpacrud.model.User;
import com.knf.dev.demo.springbootfreemarkerjpacrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> getAllusers() {
        List<User> result = (List<User>) repository.findAll();
        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<User>();
        }
    }

    public User getUserById(Long id) throws RecordNotFoundException {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }

    public User createOrUpdateUser(User entity) {
        if (entity.getId() == null) {
            entity = repository.save(entity);
            return entity;
        } else {
            Optional<User> user = repository.findById(entity.getId());
            if (user.isPresent()) {
                User newEntity = user.get();
                newEntity.setEmail(entity.getEmail());
                newEntity.setFirstName(entity.getFirstName());
                newEntity.setLastName(entity.getLastName());
                newEntity = repository.save(newEntity);
                return newEntity;
            } else {
                entity = repository.save(entity);
                return entity;
            }
        }
    }

    public void deleteUserById(Long id) throws RecordNotFoundException {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }
} 
