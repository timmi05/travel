package by.intexsoft.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@Autowired
	private TourService tourService;

	/**
	 * Return all {@link Tour#name} in line
	 */
	@RequestMapping(value = "/tours")
	public List<Tour> findAllTours() {
		return tourService.findAll();
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
	public List<Tour> findAByCountry(@RequestBody Country country) {
		return tourService.findByCountry(country);
	}
}
