package by.intexsoft.course.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Hotel;
import by.intexsoft.course.model.Town;

/**
 * Service for {@link Hotel}
 */
public interface HotelService {

	/**
	 * Find all {@link Hotel}
	 */
	List<Hotel> findAll();

	/**
	 * Find {@link Hotel}
	 */
	Hotel findByName(String name);

	/**
	 * Find list {@link Hotel}s by {@link Country}
	 */
	List<Hotel> findByTownCountry(Country country);

	/**
	 * Find list {@link Hotel}s by {@link Town}
	 */
	List<Hotel> findByTown(Town town);

	/**
	 * Save new {@link Hotel}
	 */
	@Transactional
	Hotel save(Hotel hotel);

	@Transactional
	void deleteAll();
}
