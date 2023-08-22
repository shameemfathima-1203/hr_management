package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceimpl implements UserService {
    @Autowired
	private UserRepository userRepository;
    
	@Override
	public boolean adduser(User user) {
		// TODO Auto-generated method stub
		boolean userExists = userRepository.existsByEmail(user.getEmail());
		if(!userExists)
		{
			userRepository.save(user);
			return true;
		}else {
			
			return false;
		}
	}
	
	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public boolean updateuser(Long id,User user) {
		// TODO Auto-generated method stub
		userRepository.saveAndFlush(user);
		Optional<User>existingUserOptional =userRepository.findById(id);
		if(existingUserOptional.isPresent()) {
		User userExists=existingUserOptional.get();
		userExists.setFirstName(user.getFirstName());
		userExists.setLastName(user.getLastName());
		userExists.setEmail(user.getEmail());
		userExists.setPassword(user.getPassword());
		userRepository.save(userExists);
		return true;
	}else {
		return false;
	}

}
	@Override
	public boolean deleteUser(Long id) {
		Optional<User>existingUserOptional=userRepository.findById(id);
		if(existingUserOptional.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
}