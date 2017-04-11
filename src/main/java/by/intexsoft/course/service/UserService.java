package by.intexsoft.course.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.intexsoft.course.model.User;

/**
 * Service for {@link User}
 */
public interface UserService {

	/**
	 * Find all {@link User}
	 */
	List<User> findAll();

	/**
	 * Find {@link User} by username
	 */
	User findByUsername(String username);

	/**
	 * Save new {@link User}
	 */
	@Transactional
	User save(User user);
	
	/**
	 * Save new {@link User}
	 */
	@Transactional
	User registration(User user);

	/**
	 * Delete all {@link User}
	 */
	@Transactional
	void deleteAll();

	/**
	 * Update {@link User}
	 */
	@Transactional
	User update(User user);
}
