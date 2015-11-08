package db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.Mongo;

import user.User;
/*
public class Mong {

	
		  private static final Log log = LogFactory.getLog(MongoApp.class);

		  public static void main(String[] args) throws Exception {

		    MongoOperations mongoOps = new MongoTemplate(new Mongo(), "database");
		    mongoOps.insert(new User("Joe", "34"));

		   // log.info(mongoOps.findOne(query(where("name").is("Joe")), User.class));
		  }

		   
	

}
*/