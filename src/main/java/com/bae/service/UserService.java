package com.bae.service;

import java.util.Collection;
import java.util.Optional;

import com.bae.entity.User;

public interface UserService {

	Collection<User> getAllUsers();

	Optional<User> getAUser(Long id);

	String updateUser(User user);

	String deleteUser(User user);

	User createUser(User user);

	String search(Long id, String searchTerm);


}
