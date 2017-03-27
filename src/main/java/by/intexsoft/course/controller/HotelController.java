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
import by.intexsoft.course.model.Town;
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
	 * Return all {@link Hotel#name} in line
	 */
	@RequestMapping(value = "/hotel")
	public List<Hotel> findAllHotels() {
		return hotelService.findAll();
	}

	/**
	 * Return all {@link Hotel#name} in line
	 */
	@RequestMapping(value = "/hotelsintown")
	public List<Hotel> findByTown(@RequestBody Town town) {
		return hotelService.findByTown(town);
	}

	/**
	 * Return all {@link Hotel#name} in line
	 */
	@RequestMapping(value = "/hotelsincountry")
	public List<Hotel> findAByCountry(@RequestBody Country country) {
		return hotelService.findByTownCountry(country);
	}

	@RequestMapping(value = "/hotel", method = RequestMethod.POST)
	public ResponseEntity<?> addHotel(@RequestBody Hotel hotel) {
		LOGGER.info("Start addHotel");
		try {
			return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("Error in addHotel. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/hotel", method = RequestMethod.PUT)
	public ResponseEntity<?> updateHotel(@RequestBody Hotel hotel) {
		LOGGER.info("start updateHotel");
		try {
			return new ResponseEntity<>(hotelService.update(hotel), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in updateHotel. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
