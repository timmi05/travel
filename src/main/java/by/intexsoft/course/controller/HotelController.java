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

import by.intexsoft.course.model.Hotel;
import by.intexsoft.course.service.HotelService;

/**
 * RestController for {@link Hotel}
 */
@RestController
public class HotelController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	private HotelService hotelService;

	/**
	 * Return all {@link Hotel}
	 */
	@RequestMapping(value = "/hotel")
	public ResponseEntity<?> findAll() {
		LOGGER.info("Start findAll hotels");
		try {
			return new ResponseEntity<>(hotelService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in findAll hotels. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Add {@link Hotel}
	 */
	@RequestMapping(value = "/hotel", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Hotel hotel) {
		LOGGER.info("Start add hotel");
		try {
			return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("Error in add hotel. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Update {@link Hotel}
	 */
	@RequestMapping(value = "/hotel", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Hotel hotel) {
		LOGGER.info("start update hotel");
		try {
			return new ResponseEntity<>(hotelService.update(hotel), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in update hotel. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
