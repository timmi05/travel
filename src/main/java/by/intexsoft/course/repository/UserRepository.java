package by.intexsoft.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.course.model.User;

/**
 * Repository for {@link User}
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
