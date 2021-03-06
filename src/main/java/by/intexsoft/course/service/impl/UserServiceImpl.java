package by.intexsoft.course.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.course.model.Authority;
import by.intexsoft.course.model.User;
import by.intexsoft.course.repository.UserRepository;
import by.intexsoft.course.service.AuthorityService;
import by.intexsoft.course.service.UserService;

/**
 * It used to implement the techniques {@link UserService}
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityService authorityService;

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
	public User registration(User user) {				
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.findByAuthority("ROLE_USER"));
		user.authorities = authorities;
		return userRepository.saveAndFlush(user);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public User update(User user) {
		return userRepository.saveAndFlush(user);
	}
}
