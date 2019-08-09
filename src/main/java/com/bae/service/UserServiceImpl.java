package com.bae.service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.SearchLogs;
import com.bae.entity.User;
import com.bae.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	private UserRepo repo;
	private RestTemplate restTemplate;
	private JmsTemplate jmsTemplate;


	@Autowired
	public UserServiceImpl(UserRepo repository, RestTemplate restTemplate, JmsTemplate jmsTemplate) {

		this.repo = repository;
		this.restTemplate = restTemplate;
		this.jmsTemplate = jmsTemplate;

	}

	public UserServiceImpl() {

	}

	@Override
	public Collection<User> getAllUsers() {
		return repo.findAll();

	}
//
//	@Override
//	public User getAUser(Long id) {
//		User aUser = repo.findById(id).get();
//		return aUser;
//	}

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

	@Override
	public Optional<User> getAUser(Long id) {
		Optional<User> user = repo.findById(id);
		return user;
	}
	
	@Override
	public String search(Long id, String searchTerm) {
		
		Optional<User> optUser =  repo.findById(id);
		
		if(optUser.isPresent()) {
			
			
			//create that SearchLogs object
			
			//sending search logs to q
	
			//get body localhost:8086/search/ restteamplate
			ResponseEntity<String> search = restTemplate.exchange("http://localhost:8086/search/"+ id + searchTerm,
					HttpMethod.GET, null, String.class);
			String searchResult = search.getBody();
			User user=optUser.get();
			
			sendtoQueue(user, searchTerm);
			
		}else {
			
			return "user doesnt exist";
			
		}	
		
		return "";
	}

	private void sendtoQueue(User user, String searchTerm) {
		
		SearchLogs newLog = new SearchLogs();
		jmsTemplate.convertAndSend("UserQueue", newLog);
	}



}
