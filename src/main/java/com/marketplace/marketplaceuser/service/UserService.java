package com.marketplace.marketplaceuser.service;

import java.util.List;

import com.marketplace.marketplaceuser.entity.User;

public interface UserService {

	List<User> getUsers();

	User saveUser(User user);

	User getUserById(Integer id);

	User updateUser(User user, Integer id);

	String deleteUser(Integer id);

}
