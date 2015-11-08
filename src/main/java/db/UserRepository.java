package db;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import user.User;


@Component
public interface UserRepository extends MongoRepository<User, String>{
	public User findByUsername(String username);
	//public List<User> findB(String username);

}
