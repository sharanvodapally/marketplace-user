package com.marketplace.marketplaceuser.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9204636819414363587L;

	public UserNotFoundException(Integer id) {
		super("Could not find user :" + id);
	}
}
