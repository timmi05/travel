package by.intexsoft.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.course.model.Town;

/**
 * Repository for {@link Town}
 */
public interface TownRepository extends JpaRepository<Town, Long> {
}
