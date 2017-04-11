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

import by.intexsoft.course.model.Town;
import by.intexsoft.course.service.TownService;

/**
 * RestController for {@link Town}
 */
@RestController
public class TownController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TownController.class);

	@Autowired
	private TownService townService;

	/**
	 * Return all {@link Town}
	 */
	@RequestMapping(value = "/town")
	public ResponseEntity<?> findAll() {
		LOGGER.info("Start findAll towns");
		try {
			return new ResponseEntity<>(townService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in findAll towns. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Add {@link Town}
	 */
	@RequestMapping(value = "/town", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Town town) {
		LOGGER.info("Start add town");
		try {
			return new ResponseEntity<>(townService.save(town), HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("Error in add town. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Update {@link Town}
	 */
	@RequestMapping(value = "/town", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Town town) {
		LOGGER.info("start update town");
		try {
			return new ResponseEntity<>(townService.update(town), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in update town. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
