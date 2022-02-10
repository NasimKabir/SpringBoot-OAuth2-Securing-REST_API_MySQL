package com.spring.oauth2example.service;

import com.spring.oauth2example.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void save(User user);

    public Optional<User> update(int userId,User user);

    public void delete(int userId);

    public List<User> getUsers();

    public Optional<User> getUserById(int userId);

    public User getUserByUserName(String userName);
}
