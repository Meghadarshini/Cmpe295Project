package project;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;



import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


import com.mongodb.Mongo;

//import db.MongoApp;
import db.UserRepository;
import user.User;
/*
public abstract class ApplicationHandler implements UserRepository{
	MongoApp mongoApp;

	public void insertUser(User user) {
		mongoApp.insertUserToRepository(user);
		
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

*/
