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
import by.intexsoft.course.model.Hotel;
import by.intexsoft.course.model.Tour;
import by.intexsoft.course.model.Town;
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
	 * Return all {@link Tour#name} in line
	 */
	@RequestMapping(value = "/tour")
	public List<Tour> findAllTours() {
		return tourService.findAll();
	}
	
	@RequestMapping(value = "/tours", method = RequestMethod.POST)
	public List<Tour> findTours(@RequestBody Tour tour) {
		LOGGER.info("Start load tours");
		return tourService.findTours(tour);
	}	

	/**
	 * Return all {@link Tour#name} in line
	 */
	@RequestMapping(value = "/toursinhotel")
	public List<Tour> findByTown(@RequestBody Hotel hotel) {
		return tourService.findByHotel(hotel);
	}

	/**
	 * Return all {@link Tour#name} in line
	 */
	@RequestMapping(value = "/toursintown")
	public List<Tour> findByTown(@RequestBody Town town) {
		return tourService.findByTown(town);
	}

	/**
	 * Return all {@link Tour#name} in line
	 */
	@RequestMapping(value = "/toursincountry")
	public List<Tour> findByCountry(@RequestBody Country country) {
		return tourService.findByCountry(country);
	}

	@RequestMapping(value = "/tour", method = RequestMethod.PUT)
	public ResponseEntity<?> addTour(@RequestBody Tour tour) {
		LOGGER.info("Start addTour");
		try {
			return new ResponseEntity<>(tourService.save(tour), HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("Error in addTour. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/tours", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTour(@RequestBody Tour tour) {
		LOGGER.info("start updateTour");
		try {
			return new ResponseEntity<>(tourService.update(tour), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in updateTour. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/tourbymanager", method = RequestMethod.POST)
	public ResponseEntity<?> updateTourByManager(@RequestBody Tour tour) {
		LOGGER.info("start updateTour");
		try {
			return new ResponseEntity<>(tourService.update(tour), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in updateTour. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
