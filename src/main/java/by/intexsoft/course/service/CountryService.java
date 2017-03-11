package by.intexsoft.course.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.intexsoft.course.model.Country;

/**
 * Service for {@link Country}
 */
public interface CountryService {

	/**
	 * Find all {@link Country}
	 */
	List<Country> findAll();

	/**
	 * Save new {@link Country}
	 */
	@Transactional
	Country save(Country country);
}
