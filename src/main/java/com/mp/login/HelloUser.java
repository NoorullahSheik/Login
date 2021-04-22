package com.mp.login;

import org.springframework.web.bind.annotation.RestController;
 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloUser {
	// @RequestMapping({"/login"})
	/* @RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String login() {
		return "login";
	} */

	@RequestMapping("/")
	public String index() {
		// returns to home.html
		return "home";
	}

	@RequestMapping(value ="/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	
}
