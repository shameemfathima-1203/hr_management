package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
public boolean adduser(User user);
public List<User> getUser();
public boolean updateuser(Long id, User user);

boolean deleteUser(Long id);
}