package by.intexsoft.course.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Hotel;
import by.intexsoft.course.model.Tour;
import by.intexsoft.course.model.Town;
import by.intexsoft.course.model.User;

/**
 * Service for {@link Tour}
 */
public interface TourService {

	/**
	 * Find all {@link User}
	 */
	List<Tour> findAll();

//	/**
//	 * Find {@link Tour}
//	 */
//	Tour findByName(String name);

	/**
	 * Find List {@link Tour}s by {@link User}
	 */
	List<Tour> findByUser(User user);

	/**
	 * Find List {@link Tour}s by {@link Country}
	 */
	List<Tour> findByHotelTownCountry(Country country);

	/**
	 * Find List {@link Tour}s by {@link Town}
	 */
	List<Tour> findByHotelTown(Town town);

	/**
	 * Find List {@link Tour}s by {@link Hotel}
	 */
	List<Tour> findByHotel(Hotel hotel);

	/**
	 * Find List {@link Tour}s by {@link Country}
	 */
	List<Tour> findByCountry(Country country);

	/**
	 * Find List {@link Tour}s by {@link Town}
	 */
	List<Tour> findByTown(Town town);

	/**
	 * Save new {@link Tour}
	 */
	@Transactional
	Tour save(Tour tour);
	
	@Transactional
	Tour update(Tour tour);

	@Transactional
	void deleteAll();
}
