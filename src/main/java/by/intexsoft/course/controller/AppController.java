package by.intexsoft.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.User;
import by.intexsoft.course.service.CountryService;
import by.intexsoft.course.service.UserService;

/**
 * RestController for {@link Country} 
 */
@RestController
public class AppController {

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private UserService userService;

	/**
	 * Return all {@link Country#name} in line
	 */
	@RequestMapping(value = "/country")
	public List<Country> findAllCountries() {		
		return countryService.findAll();
	}

	/**
	 * Returns the word hello
	 */
	@RequestMapping(value = "/hi")
	public String getHelloUsers() {
		String message = "Hello !";
		return message;
	}
	
	/**
	 * Return all {@link User} in line
	 */
	@RequestMapping(value = "/users")
	public List<User> findAllUsers() {		
		return userService.findAll();
	}
}
