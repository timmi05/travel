package by.intexsoft.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.course.model.Role;

/**
 * Repository for {@link Role}
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
