package by.intexsoft.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.course.model.Authority;

/**
 * Repository for {@link Authority}
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	Authority findByAuthority(String authority);
}
