package com.codenation.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codenation.entities.User;
import com.codenation.service.interfaces.UserServiceInterface;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserServiceInterface userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}
}
