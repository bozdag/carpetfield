package com.carpetfield.server.controller;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import com.carpetfield.server.domain.auth.User;
import com.carpetfield.server.repo.UserRepository;
import com.carpetfield.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by alicana on 09/03/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/* GET /users */
	@RequestMapping(method = RequestMethod.GET)
	public Collection<User> list()
	{
		return userService.getAllUsers();
	}

	/* GET /users/1 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id)
	{
		return userService.getUserById(id).orElseThrow( () -> new NoSuchElementException("User not found"));
	}

	/* POST /users {user data} */
	@RequestMapping(method = RequestMethod.POST)
	public User createUser(@RequestBody @Valid final User user)
	{
		return userService.createOrUpdate(user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id)
	{
		userService.deleteUserById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public User update(@PathVariable Long id, @RequestBody @Valid final User user)
	{
		User update = userService.getUserById(id).orElseThrow( () -> new NoSuchElementException("User not found"));
		// MARK: <Alternative> BeanUtils.copyProperties
		update.setEmail( user.getEmail() );
		update.setPasswordHash( user.getPasswordHash() );
		update.setRole( user.getRole() );
		return userService.createOrUpdate( update );
	}

}
