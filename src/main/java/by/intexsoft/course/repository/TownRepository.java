package by.intexsoft.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Town;

/**
 * Repository for {@link Town}
 */
public interface TownRepository extends JpaRepository<Town, Long> {

	Town findByName(String name);

	List<Town> findByCountry(Country country);
}
