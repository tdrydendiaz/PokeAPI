package com.bae.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bae.entity.User;
import com.bae.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	private UserRepo repo;

	@Autowired
	public UserServiceImpl(UserRepo userRepo) {
		this.repo = userRepo;

	}

	public UserServiceImpl() {

	}

	@Override
	public Collection<User> getAllUsers() {
		return repo.findAll();

	}

	@Override
	public User getAUser(Long id) {
		User aUser = repo.findById(id).get();
		return aUser;
	}

	@Override
	public String updateUser(User user) {
		repo.deleteById(user.getId());
		repo.save(user);
		return user.toString();
	}

	@Override
	public String deleteUser(User user) {
		repo.delete(user);
		return "User deleted";

	}

	@Override
	public User createUser(User user) {
		return repo.save(user);

	}

}
