package by.intexsoft.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Town;
import by.intexsoft.course.service.TownService;

/**
 * RestController for {@link Town}
 */
@RestController
public class TownController {

	@Autowired
	private TownService townService;

	/**
	 * Return all {@link Town#name} in line
	 */
	@RequestMapping(value = "/towns")
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
}
