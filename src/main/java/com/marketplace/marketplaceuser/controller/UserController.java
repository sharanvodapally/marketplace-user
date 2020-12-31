package com.marketplace.marketplaceuser.controller;

import java.util.List;

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

import com.marketplace.marketplaceuser.entity.User;
import com.marketplace.marketplaceuser.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "API's for users")
@RestController
@RequestMapping("v1/users")
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "API to get Users", response = User.class, responseContainer = "List")
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@ApiParam(required = true, value = "unique user id", example = "1") @PathVariable Integer id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}

	@ApiOperation(value = "API to add User", response = User.class)
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@ApiOperation(value = "API to update User", response = User.class)
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "API to delete User")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		return new ResponseEntity<String>(userService.deleteUser(id), HttpStatus.NO_CONTENT);
	}

}