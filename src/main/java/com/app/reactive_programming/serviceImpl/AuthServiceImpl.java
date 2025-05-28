package com.app.reactive_programming.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.reactive_programming.entity.User;
import com.app.reactive_programming.enums.UserRoleType;
import com.app.reactive_programming.input.LoginInput;
import com.app.reactive_programming.input.RegisterInput;
import com.app.reactive_programming.repository.AuthRepository;
import com.app.reactive_programming.service.AuthService;

import reactor.core.publisher.Mono;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthRepository authRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Mono<User> registerUser(RegisterInput registerInput) {
        User user = modelMapper.map(registerInput, User.class);
        user.setRole(UserRoleType.USER);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setDeleted(false);
        user.setActive(true);
        return authRepository.save(user);
    }

    @Override
    public Mono<User> registerOwner(RegisterInput registerInput) {
        User user = modelMapper.map(registerInput, User.class);
        user.setRole(UserRoleType.OWNER);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setDeleted(false);
        user.setActive(true);
        return authRepository.save(user);
    }

    @Override
    public Mono<User> loginUser(LoginInput LoginInput) {
        return null;
    }

}
