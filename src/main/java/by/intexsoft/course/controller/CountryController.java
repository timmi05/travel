package by.intexsoft.course.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.service.CountryService;

/**
 * RestController for {@link Country}
 */
@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private CountryService countryService;

	/**
	 * Return all {@link Country#name} in line
	 */
	@RequestMapping(value = "/country")
	public List<Country> findAll() {
		return countryService.findAll();
	}

	@RequestMapping(value = "/country", method = RequestMethod.POST)
	public ResponseEntity<?> addCountry(@RequestBody Country country) {
		LOGGER.info("Start addCountry");
		try {
			return new ResponseEntity<>(countryService.save(country), HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("Error in addCountry. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/country", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCountry(@RequestBody Country country) {
		LOGGER.info("start updateCountry");
		try {
			return new ResponseEntity<>(countryService.update(country), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in updateCountry. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
