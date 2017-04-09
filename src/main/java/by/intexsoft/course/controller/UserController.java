package by.intexsoft.course.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.course.model.User;
import by.intexsoft.course.service.UserService;

/**
 * RestController for {@link User}
 */
@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * Return all {@link User} in line
	 */
	@RequestMapping(value = "/user")
	public List<User> findAll() {
		return userService.findAll();
	}

	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	public ResponseEntity<?> findUser(@PathVariable("username") String username) {
		LOGGER.info("Start findUser");
		try {
			return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in findUser. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<?> registrationUser(@RequestBody User user) {
		LOGGER.info("Start addUser");
		try {
			return new ResponseEntity<>(userService.registration(user), HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("Error in addUser. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody User user) {
		LOGGER.info("Start addUser");
		try {
			return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("Error in addUser. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		LOGGER.info("start updateUser");
		try {
			return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Error in updateUser. " + e.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
