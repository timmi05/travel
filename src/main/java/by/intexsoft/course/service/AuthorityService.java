package by.intexsoft.course.service;

import java.util.List;

import by.intexsoft.course.model.Authority;

/**
 * Service for {@link Authority}
 */
public interface AuthorityService {

	/**
	 * Find all {@link Authority}
	 */
	List<Authority> findAll();

	/**
	 * Find {@link Authority}
	 */
	Authority findByAuthority(String authority);
}
