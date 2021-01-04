package com.marketplace.marketplaceuser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.marketplace.marketplaceuser.entity.User;
import com.marketplace.marketplaceuser.exception.UserNotFoundException;
import com.marketplace.marketplaceuser.repository.UserRepository;
import com.marketplace.marketplaceuser.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class MarketplaceUserApplicationTests {

	@InjectMocks
	private UserServiceImpl service;

	@Mock
	private UserRepository userRepository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this); // without this you will get NPE
	}

	@Test
	void contextLoads() {
		assertThat(service).isNotNull();
	}

	@Test
	void findUserByIdTestNotFound() {
		Mockito.when(userRepository.findById(1)).thenReturn(Optional.empty());
		assertThrows(UserNotFoundException.class, () -> {
			service.getUserById(1);
		});

	}

	@Test
	void findUserByIdTestFound() {
		long millis = System.currentTimeMillis();
		java.util.Date date = new java.util.Date(millis);

		User user = new User(Integer.valueOf(1), "sharan", "shara", null, null, null, "shara", "sahran");

		Optional<User> assetOp = Optional.of(user);
		Mockito.when(userRepository.findById(user.getId())).thenReturn(assetOp);
		assertEquals(service.getUserById(user.getId()), user);
	}

}
