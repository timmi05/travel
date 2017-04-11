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

import by.intexsoft.course.model.Tour;
import by.intexsoft.course.model.User;
import by.intexsoft.course.service.TourService;

/**
 * RestController for {@link Tour}
 */
@RestController
public class TourController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TourController.class);

	@Autowired
	private TourService tourService;

	/**
	 * Return all {@link Tour#name} for users
	 */
	@RequestMapping(value = "/tours", method = RequestMethod.POST)
	public ResponseEntity<?> findTours(@RequestBody Tour tour) {
		LOGGER.info("Start load tours");
		try {
			return new ResponseEntity<>(tourService.findTours(tour), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in getUserTours. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Return all {@link Tour#name} for manager
	 */
	@RequestMapping(value = "/managertours", method = RequestMethod.POST)
	public ResponseEntity<?> findToursForManager(@RequestBody Tour tour) {
		LOGGER.info("Start load tours");
		try {
			return new ResponseEntity<>(tourService.findToursForManager(tour), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in getUserTours. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/mytours", method = RequestMethod.POST)
	public ResponseEntity<?> loadUsersTours(@RequestBody User user) {
		LOGGER.info("Start loadUserTours");
		try {
			return new ResponseEntity<>(tourService.findByUser(user), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in getUserTours. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/tour", method = RequestMethod.PUT)
	public ResponseEntity<?> create(@RequestBody Tour tour) {
		LOGGER.info("Start create tour");
		try {
			return new ResponseEntity<>(tourService.save(tour), HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("Error in create tour. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public ResponseEntity<?> booking(@RequestBody Tour tour) {
		LOGGER.info("start booking");
		try {
			return new ResponseEntity<>(tourService.booking(tour), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in booking. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/booking", method = RequestMethod.PUT)
	public ResponseEntity<?> unBooking(@RequestBody Tour tour) {
		LOGGER.info("start unBooking");
		try {
			return new ResponseEntity<>(tourService.unBooking(tour), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in unBooking. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/tour", method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody Tour tour) {
		LOGGER.info("start update tour");
		try {
			return new ResponseEntity<>(tourService.update(tour), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in update tour. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
