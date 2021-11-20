package com.knf.dev.demo.springwebfluxsimplecrudexample.repository;

import com.knf.dev.demo.springwebfluxsimplecrudexample.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
