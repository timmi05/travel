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
import by.intexsoft.course.model.Town;
import by.intexsoft.course.service.CountryService;
import by.intexsoft.course.service.TownService;

/**
 * RestController for {@link Town}
 */
@RestController
public class TownController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TownController.class);

	@Autowired
	private TownService townService;

	@Autowired
	private CountryService countryService;

	/**
	 * Return all {@link Town#name} in line
	 */
	@RequestMapping(value = "/town")
	public List<Town> findAll() {
		return townService.findAll();
	}

	/**
	 * Return all {@link Town#name} in line
	 */
	@RequestMapping(value = "/townsincountry")
	public List<Town> findByCountry(@RequestBody Country country) {
		return townService.findByCountry(country);
	}

	@RequestMapping(value = "/town", method = RequestMethod.POST)
	public ResponseEntity<?> addTown(@RequestBody Town town) {
		LOGGER.info("Start addTown");
		try {
			return new ResponseEntity<>(townService.save(town), HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("Error in addTown. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/town", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTown(@RequestBody Town town) {
		LOGGER.info("start updateTown");
		try {
			return new ResponseEntity<>(townService.update(town), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in updateTown. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
