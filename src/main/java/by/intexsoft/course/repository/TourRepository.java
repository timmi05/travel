package by.intexsoft.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.course.model.Tour;

/**
 * Repository for {@link Tour}
 */
public interface TourRepository extends JpaRepository<Tour, Long> {
}
