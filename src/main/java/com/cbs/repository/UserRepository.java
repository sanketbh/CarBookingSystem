package com.cbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbs.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
