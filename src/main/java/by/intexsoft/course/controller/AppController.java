package by.intexsoft.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.service.CountryService;

/**
 * RestController for {@link Country} 
 */
@RestController
public class AppController {

	@Autowired
	private CountryService countryService;

	/**
	 * Return all {@link Country#name} in line
	 */
	@RequestMapping(value = "/co")
	public List<Country> findAllCountries() {		
		return countryService.findAll();
	}

	/**
	 * Returns the word hello
	 */
	@RequestMapping(value = "/")
	public String getHelloUsers() {
		String message = "Hello !";
		return message;
	}
}
