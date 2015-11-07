package project;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import user.User;
 

@Controller
@RequestMapping("/Cmpe295BProject")
public class ApplicationController {
	
	/*
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    */

	
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
	
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String checkUserInfo(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
    /*    if(bindingResult.hasErrors()) {
            return "index";
        }  */
    	user = new User();
        model.addAttribute("user", user); 
        return "ref";
        
        /*
        
        try {
            user = projectHandler.doesUserExist(user.getUsername());
            model.addAttribute("user", user);
            //return "predict";
        } catch ( Exception e) {
            model.addAttribute("message", "Please login to continue");
            return "index";
        } catch (Exception e) {
            model.addAttribute("message", "Username or password is incorrect");
            return "index";
        } */
      //  return "redirect:/cmpe295project/predict";
    }

	
}

