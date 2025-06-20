package com.app.reactive_programming.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.reactive_programming.entity.User;
import com.app.reactive_programming.repository.UserRepository;
import com.app.reactive_programming.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public Mono<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<Boolean> deleteUser(String id) {
        return userRepository.findById(id).flatMap(user -> {
            user.setDeleted(true);
            return userRepository.save(user).then(Mono.just(true));
        }).switchIfEmpty(Mono.just(false));
    }
}
