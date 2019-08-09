package com.bae.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.entity.User;
import com.bae.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/all")
	public Collection<User> getAllUsers() {
		return service.getAllUsers();
	}
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User NewUser = service.createUser(user);
//		sendToQueue(user);
		return new ResponseEntity<>(NewUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(User user) {
		return service.deleteUser(user);
	}
	
	@PutMapping("updateUser/{id}")
	public String updateUser(User user) {
		return service.updateUser(user);
	}
	
	@GetMapping("/getAUser/{id}")
	public Optional<User> getAUser(@PathVariable("id") Long id) {
		return service.getAUser(id);
	}

	@GetMapping("/search/{id}/{searchTerm}")
	public String search(@PathVariable("id") Long id, @PathVariable("searchTerm") String searchTerm) {
		return service.search(id, searchTerm);
	}

}
