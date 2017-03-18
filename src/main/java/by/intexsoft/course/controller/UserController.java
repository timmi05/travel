package by.intexsoft.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.course.model.User;
import by.intexsoft.course.service.UserService;

/**
 * RestController for {@link User}
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Return all {@link User} in line
	 */
	@RequestMapping(value = "/users")
	public List<User> findAll() {
		return userService.findAll();
	}
}
