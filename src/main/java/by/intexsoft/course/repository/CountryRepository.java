package by.intexsoft.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.course.model.Country;

/**
 * Repository for {@link Country}
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
}
