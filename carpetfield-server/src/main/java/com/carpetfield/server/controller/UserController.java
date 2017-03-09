package com.carpetfield.server.controller;

import java.util.List;

import com.carpetfield.server.domain.auth.User;
import com.carpetfield.server.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alicana on 09/03/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> list(){
		return userRepository.findAll();
	}

}
