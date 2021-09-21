package com.knf.dev.demo.springwebfluxsimplecrudexample.controller;

import com.knf.dev.demo.springwebfluxsimplecrudexample.model.User;
import com.knf.dev.demo.springwebfluxsimplecrudexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/user")
    Flux<User> getAll() {
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    Mono<User> getUser(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @PostMapping("/user")
    Mono<User> addUser(@RequestBody User user) {
        return repository.save(user);
    }


    @PutMapping("/user/{id}")
    private Mono<User> updateUser(@PathVariable("id") Long id,
                                  @RequestBody User user) {
        return repository.findById(id).flatMap(user1 -> {
            user.setId(id);
            return repository.save(user);
        }).switchIfEmpty(Mono.empty());
    }

    @DeleteMapping("/user/{id}")
    Mono<Void> deleteById(@PathVariable("id") Long id) {
        return repository.findById(id).flatMap(p ->
                repository.deleteById(p.getId()));
    }
}
