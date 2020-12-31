package com.marketplace.marketplaceuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.marketplaceuser.entity.User;
import com.marketplace.marketplaceuser.exception.UserNotFoundException;
import com.marketplace.marketplaceuser.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@Override
	public User updateUser(User user, Integer id) {
		return userRepository.findById(id).map(u -> {
			u.setName(user.getName());
			u.setCity(user.getCity());
			u.setDob(user.getDob());
			u.setId(user.getId());
			return userRepository.save(u);
		}).orElseGet(() -> {
			user.setId(id);
			return userRepository.save(user);
		});
	}

	@Override
	public String deleteUser(Integer id) {
		userRepository.deleteById(id);
		return "Successfully deleted";
	}

}
