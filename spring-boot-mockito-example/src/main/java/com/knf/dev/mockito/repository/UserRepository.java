package com.knf.dev.mockito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knf.dev.mockito.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByName(String name);

}
