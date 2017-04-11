package by.intexsoft.course.controller;

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
	 * Return all {@link Country}
	 */
	@RequestMapping(value = "/country")
	public ResponseEntity<?> findAll() {
		LOGGER.info("Start findAll countries");
		try {
			return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in findAll countries. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Add {@link Country}
	 */
	@RequestMapping(value = "/country", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Country country) {
		LOGGER.info("Start add country");
		try {
			return new ResponseEntity<>(countryService.save(country), HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("Error in add country. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Update {@link Country}
	 */
	@RequestMapping(value = "/country", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Country country) {
		LOGGER.info("start update country");
		try {
			return new ResponseEntity<>(countryService.update(country), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in update country. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
