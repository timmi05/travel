package by.intexsoft.course.service;

import by.intexsoft.course.model.User;

/**
 * Service for generating token
 */
public interface TokenService {

	/**
	 * Generate token
	 * 
	 * @return generated token
	 */
	String generate(User user, String password);
}
