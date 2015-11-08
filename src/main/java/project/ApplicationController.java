package project;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import db.UserRepository;
import user.User;


@Controller
@RequestMapping("/Cmpe295BProject")
public class ApplicationController {
	UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)	
	public String getIndexPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "index";
	}
	

	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegistrationPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);		
		return "register";
	}
	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkUserInfo(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "register";
        }  
    	user = new User();
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username);
        System.out.println(password);
        model.addAttribute("user", user); 
        userService.userPost(user);
        return "index";
    }
	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String createUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "register";
        } 
        try {
        	user.setUsername(user.getUsername());
        	user.setPassword(user.getPassword());
        	userService.checkUser(user);
        }	catch(Exception e) {
        	e.printStackTrace();
		 
		}
        return "index";
	}
	
	/*
	@RequestMapping(value = "/index", method = RequestMethod.GET )
	public String create(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "index";
		/*
        if(bindingResult.hasErrors()) {
            return "index";
        } 
        try {
        	model.addAttribute(user);
        	
        }	catch(Exception e) {
        	e.printStackTrace();
		 
		}
        return "redirect:/Cmpe295BProject/index";
        
	}
	
	
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = "application/json",  consumes = "application/json")
    @ResponseBody
    public HttpEntity get( @ModelAttribute User user) {
    	
       user = userService.checkUser(user);
      // return "index";
       return new ResponseEntity(HttpStatus.CREATED);
    }
    */
    /*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute("user") User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "register";
		}
		return "index";
		
	}
	
	
    @RequestMapping(value = "/login", method = RequestMethod.POST,  consumes = "application/json", 
    	    headers = "content-type=application/x-www-form-urlencoded")
   
    public @ResponseBody String get(@ModelAttribute User user, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		return "index";
    	}
    	
    	try {
    		model.addAttribute("user", user);
    		// user = userService.checkUser(user);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
      return "index";
       //return "redirect:/Cmpe295BProject/index/users";
      // return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/index/users", method = RequestMethod.GET) 
    public String userLogin () {
    	return "index";
    	
    }
    */
	
	/* sample correct
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkUserInfoAndCreateUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "index";
        }
        String username, password;
        username = user.getUsername();
        password = user.getPassword();
        user.setUsername(username);
        user.setPassword(password);
        userService.checkUser(user);
        model.addAttribute("user", user);
       // return "index";
        return "redirect:/Cmpe295BProject";
    }
    */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkUserInfoAndCreateUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "index";
        }
        String username, password;
        username = user.getUsername();
        password = user.getPassword();
        user.setUsername(username);
        user.setPassword(password);
        model.addAttribute("user", user);
        try {
        	userService.insertUser(user);
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
      
       // return "index";
        return "redirect:/Cmpe295BProject";
    }

	
	/*
	@RequestMapping(value = "", method = RequestMethod.POST)
    public String checkUserInfo(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "index";
        }  
    	user = new User();
        model.addAttribute("user", user); 
        String username = user.getUsername();
        String password = user.getPassword();
        userRepository.save(user);
        //applicationHandler.insertUser(user);  
        if(username=="megha" && password == "megha")
        {
        	return "register"; 
        }
        	return "redirect:/Cmpe295BProject"; 
    }
	*/
	/*
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getPage() {
			
		return "index";
	}
	
 */
	
}

