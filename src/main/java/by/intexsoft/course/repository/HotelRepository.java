package by.intexsoft.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Hotel;
import by.intexsoft.course.model.Town;

/**
 * Repository for {@link Hotel}
 */
public interface HotelRepository extends JpaRepository<Hotel, Long> {

	Hotel findByName(String name);

	List<Hotel> findByTownCountry(Country country);

	List<Hotel> findByTown(Town town);
}
