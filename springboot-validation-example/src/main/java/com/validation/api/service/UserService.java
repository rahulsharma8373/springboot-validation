package com.validation.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.api.dto.UserRequest;
import com.validation.api.entity.User;
import com.validation.api.exception.UserNotFoundException;
import com.validation.api.repository.UserRepository;
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	
	public User saveUser(UserRequest userRequest) {
		User user=User.build(0,userRequest.getName(), 
				userRequest.getEmail(), userRequest.getGender(), userRequest.getMobile(), userRequest.getAge(), userRequest.getNationality());
				return repository.save(user);
	}
	
	public List<User>getAllUser(){
		return repository.findAll();
		
	}
	public User getUser(int id) throws UserNotFoundException {
		User user= repository.findByUserId(id);
		if(user!=null) {
			return user;
			
		}else {
			throw new UserNotFoundException("user not found with id; "+id);
		}
	}
	
	
	
}
