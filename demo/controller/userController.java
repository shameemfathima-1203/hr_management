package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class userController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser")
	public ResponseEntity<List<User>>getUser(){
		return ResponseEntity.status(200).body(userService.getUser());
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<String>addUser(@RequestBody User user){
		boolean dataSaved= userService.adduser(user);
		if(dataSaved) {
			return ResponseEntity.status(200).body("User added successfully");
		}
		else {
			return ResponseEntity.status(404).body("Something went wrong");
		}
		
	}
	
	@PutMapping("/updateUser/{id}")
	
public ResponseEntity<String>updateuser(@PathVariable Long id,@RequestBody User user){
	boolean userData=userService.updateuser(id,user);
	if(userData) {
		return ResponseEntity.status(200).body("User updated successfully");
		
	}else {
		return ResponseEntity.status(404).body("no record");
	}

}
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Long id){
		boolean userDeleted=userService.deleteUser(id);
		if(userDeleted) {
			return ResponseEntity.status(200).body("user deleted successfully");
		}
		else {
			return ResponseEntity.status(404).body("No records");
		}
	}
}