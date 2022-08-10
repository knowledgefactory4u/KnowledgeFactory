package com.knf.dev.demo.springbootpagination.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.knf.dev.demo.springbootpagination.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Page<User> findByCountryContaining(String country, Pageable pageable);

}
