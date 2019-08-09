package com.bae.service;

import java.util.Collection;

import com.bae.entity.User;

public interface UserService {

	Collection<User> getAllUsers();

	User getAUser(Long id);

	String updateUser(User user);

	String deleteUser(User user);

	User createUser(User user);

}
