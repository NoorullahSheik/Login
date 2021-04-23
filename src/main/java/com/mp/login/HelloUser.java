package com.mp.login;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloUser {
	// @RequestMapping({"/login"})
	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public String login() { return "login"; }
	 */

	/*
	 * @RequestMapping("/") public String index() { // returns to home.html return
	 * "home"; }
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user-data");
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
