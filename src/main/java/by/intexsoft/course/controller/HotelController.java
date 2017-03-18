package by.intexsoft.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@Autowired
	private HotelService hotelService;

	/**
	 * Return all {@link Hotel#name} in line
	 */
	@RequestMapping(value = "/hotels")
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

}
