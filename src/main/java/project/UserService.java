package project;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import user.User;
import db.UserRepository;


public class UserService {
	@Autowired	
	private UserRepository userRepository;
	
	/*
	@RequestMapping(value = "", method = RequestMethod.POST)
    public String checkUserInfo(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "index";
        }  
        
        model.addAttribute("user", user); 
        String username = user.getUsername();
        String password = user.getPassword();
        userRepository.save(user);
        //applicationHandler.insertUser(user);  
		for(User u : userRepository.findAll()) {
			System.out.println(u);
		}
        return "redirect:/Cmpe295BProject"; 
    }
    */
	
	
 //@RequestMapping(value = "", method = RequestMethod.POST)
    public User checkUser(@RequestBody User user) {
    //	user = new User();
    	if(user == null) {
    		System.out.println("sys");
    	}

        userRepository.save(user);
        return user;
        //applicationHandler.insertUser(user);  
        /*
		for(User u : userRepository.findAll()) {
			System.out.println(u);
		}
		 */
       // return "index"; 
       
        
		
    }
    
    
  //  @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
//    public ResponseEntity userPost(@RequestBody User user) {
    public String userPost(@RequestBody User user) {
    	
    	if(user != null) {
    		userRepository.save(user);
    	}
       return null;
        //:TODO: Validate the details here, email format should be proper
       // return new ResponseEntity(HttpStatus.CREATED);
    }
	public void listUsers() {
		for(User user : userRepository.findAll()) {
			System.out.println(user);
			
		}
	
		}
	

/*
@RequestMapping(value="", method = RequestMethod.POST, consumes = "application/json")
public void insertUser(@RequestBody User user, Model model) {
}
	
	*/
	@RequestMapping(value="", method = RequestMethod.POST, consumes = "application/json", produces ="application/json")
	public ResponseEntity insertUser(@RequestBody User user) 	{
		
		String username = user.getUsername();
		String password = user.getPassword();
		user = new User(username, password);
		
		userRepository.save(user); //mongo 
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	/*
	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "index";
        }  
        model.addAttribute("user", user); 
        String username = user.getUsername();
        String password = user.getPassword();
        userRepository.save(user);
        return "index";
    }
	*/
 
	


}
