package com.validation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.validation.api.entity.User;
@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

public	User findByUserId(int id);

}
