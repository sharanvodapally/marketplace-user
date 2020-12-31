package com.marketplace.marketplaceuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.marketplaceuser.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
