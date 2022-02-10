package com.spring.oauth2example.service.impl;

import com.spring.oauth2example.entity.User;
import com.spring.oauth2example.repository.UserRepository;
import com.spring.oauth2example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    Logger log= LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void save(User user) {
        log.info("saving user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
    public Optional<User> update(int userId, User user) {


        return userRepository.findById(userId);

    }

    @Override
    public void delete(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getUsers() {

        List<User> users=userRepository.findAll();
        return users;
    }

    @Override
    public Optional<User> getUserById(int userId) {


        return userRepository.findById(userId);

    }


    @Override
    public User getUserByUserName(String userName) {

        return userRepository.findByUsername(userName);
    }

}
