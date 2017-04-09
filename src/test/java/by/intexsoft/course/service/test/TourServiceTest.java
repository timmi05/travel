package by.intexsoft.course.service.test;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Hotel;
import by.intexsoft.course.model.Tour;
import by.intexsoft.course.model.Town;
import by.intexsoft.course.model.User;
import by.intexsoft.course.service.CountryService;
import by.intexsoft.course.service.HotelService;
import by.intexsoft.course.service.TourService;
import by.intexsoft.course.service.TownService;
import by.intexsoft.course.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context-test.xml" })
public class TourServiceTest {
	@Autowired
	private CountryService ñountryService;

	@Autowired
	private TownService townService;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private UserService userService;

	@Autowired
	private TourService tourService;

	private static Country ñountry;
	private static Town town;
	private static Hotel hotel;
	private static User user;
	private static Tour tour;

	@Before
	public void testIn() {
		int testObjectsCount = 5;
		for (int i = 0; i < testObjectsCount; i++) {
			ñountry = new Country();
			ñountry.name = ("name" + i);
			ñountryService.save(ñountry);
			town = new Town();
			town.name = ("town" + i);
			town.country = ñountry;
			townService.save(town);
			hotel = new Hotel();
			hotel.name = ("hotel" + i);
			hotel.town = town;
			hotelService.save(hotel);
			user = new User();
			user.username = ("login" + i);
			user.password = ("pswd" + i);
			user.firstName = "qwerty";
			user.lastName = "qwerty";
			user.mail = "qwerty";
			user.phoneNumber = "qwerty";
			userService.save(user);

			tour = new Tour();
			tour.hotel = hotel;
			tour.user = user;
			tour.archive = false;
			tour.persons = 3;
			tour.startDate = new Date();
			tour.endDate = new Date();
			tour.hot = true;
			tour.country = ñountry;
			tour.town = town;
			tour.paid = false;
			tour.price = 3.6;
			tour.used = false;
			tour.nights = 5;
			tourService.save(tour);
		}
	}

	@After
	public void testOut() {
		tourService.deleteAll();
		userService.deleteAll();
		hotelService.deleteAll();
		townService.deleteAll();
		ñountryService.deleteAll();
	}
	
	@Test
	public void findByName() {
		Town someTown = townService.findByName("town2");	
		List<Tour> tours = tourService.findByTown(someTown);			
		Assert.assertTrue(tours.size() == 1);
	}
	
	@Test
	public void findByid() {
		Town someTown = townService.findByName("town2");	
		List<Tour> tours = tourService.findByTown(someTown);			
		Tour newTour = tours.get(0);
		Tour lastTour = tourService.booking(newTour);
		Assert.assertNotNull(lastTour);
	}
}
