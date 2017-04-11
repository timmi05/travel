package by.intexsoft.course.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Town;

/**
 * Service for {@link Town}
 */
public interface TownService {

	/**
	 * Find all {@link Town}
	 */
	List<Town> findAll();

	/**
	 * Find {@link Town} by name
	 */
	Town findByName(String name);

	/**
	 * Find list {@link Town}s by {@link Country}
	 */
	List<Town> findByCountry(Country country);

	/**
	 * Save new {@link Town}
	 */
	@Transactional
	Town save(Town town);

	@Transactional
	Town update(Town town);

	@Transactional
	void deleteAll();
}
