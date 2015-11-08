package db;

import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import user.User;

import com.mongodb.Mongo;

/*
public class MongoApp {
	public MongoOperations getInstance() {
		MongoOperations mongoOps = null;
		try {
			mongoOps = new MongoTemplate(new Mongo(), "database");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return mongoOps;
	}
	
	public User insertUserToRepository(User user) {
		MongoOperations mongoOps = getInstance(); 
		mongoOps.insert(user);
		return user;
	}

	
	
	
	

}
*/

