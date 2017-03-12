package by.intexsoft.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.course.model.Hotel;

/**
 * Repository for {@link Hotel}
 */
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
