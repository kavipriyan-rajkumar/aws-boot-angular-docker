package aws.boot.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aws.boot.user.model.UserModel;
import aws.boot.user.services.IUserService;
import lombok.extern.log4j.Log4j2;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api") @Log4j2
public class UserRestController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(value="/users", produces= { MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<List<UserModel>> getAllUsers(){
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value="/user/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces= { MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<UserModel> getUserById(@PathVariable("userId") Long userId) {
		return null;
	}
	
	@PostMapping(value="/user", consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HttpStatus> addUser(@Valid @RequestBody UserModel userModel) {
		return null;
	}
	
	@PutMapping(value="/user", consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces= { MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<HttpStatus> updateUser(UserModel userModel) {
		return null;
	}
	
	@DeleteMapping(value="/user/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<HttpStatus> deleteUser(Long userId) {
		return null;
	}
	
	@DeleteMapping(value="/users", consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces= { MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<HttpStatus> deleteAllUsers() {
		return null;
	}
	
	
	
	
}
