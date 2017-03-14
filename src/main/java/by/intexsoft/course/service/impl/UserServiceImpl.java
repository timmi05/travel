package by.intexsoft.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.course.model.User;
import by.intexsoft.course.repository.UserRepository;
import by.intexsoft.course.service.UserService;

/**
 * It used to implement the techniques {@link UserService}
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}
}
