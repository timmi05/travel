package by.intexsoft.course.service.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.intexsoft.course.model.User;
import by.intexsoft.course.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context-test.xml" })
public class UserServiceTest {

	@Autowired
	private UserService userService;

	private static User user;

	@Before
	public void testIn() {
		int testObjectsCount = 5;
		for (int i = 0; i < testObjectsCount; i++) {
			user = new User();
			user.username = ("login" + i);
			user.password = ("pswd" + i);
			user.firstName = "qwerty";
			user.lastName = "qwerty";
			user.mail = "qwerty";
			user.phoneNumber = "qwerty";

			userService.save(user);
		}
	}

	@After
	public void testOut() {
		userService.deleteAll();
	}

	@Test
	public void testRegistration() {
		user = new User();
		String username = "loginx";
		user.username = username;
		user.password = "pswd";
		user.firstName = "qwerty";
		user.lastName = "qwerty";
		user.mail = "qwerty";
		user.phoneNumber = "qwerty";
		userService.registration(user);
		User registrdUser = userService.findByUsername(username);
		Assert.assertNotNull(registrdUser);
	}

	@Test
	public void testUpdateUser() {
		String username = "login2";
		String password;
		String newPassword = "newPassword";
		user = userService.findByUsername(username);
		password = user.password;
		user.password = newPassword;
		userService.update(user);

		Assert.assertNotEquals(userService.findByUsername(username).password, password);
	}

	@Test
	public void testGetAll() {
		List<User> allUsers;
		allUsers = userService.findAll();
		Assert.assertEquals(5, allUsers.size());
	}
}
