package com.osvaldo.metaphorce.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RegistrationController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/signup")
	public UserEntity signup(@RequestBody UserDto user) {
		return userService.save(user);
	}

}
