package by.intexsoft.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Hotel;
import by.intexsoft.course.model.Tour;
import by.intexsoft.course.model.Town;
import by.intexsoft.course.model.User;

/**
 * Repository for {@link Tour}
 */
public interface TourRepository extends JpaRepository<Tour, Long> {

	Tour findByName(String name);

	List<Tour> findByUser(User user);

	List<Tour> findByHotelTownCountry(Country country);

	List<Tour> findByHotelTown(Town town);

	List<Tour> findByHotel(Hotel hotel);

	List<Tour> findByCountry(Country country);

	List<Tour> findByTown(Town town);
}
