package com.knf.dev.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knf.dev.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}