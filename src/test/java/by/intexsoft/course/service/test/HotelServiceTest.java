package by.intexsoft.course.service.test;

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
import by.intexsoft.course.model.Town;
import by.intexsoft.course.service.CountryService;
import by.intexsoft.course.service.HotelService;
import by.intexsoft.course.service.TownService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context-test.xml" })
public class HotelServiceTest {

	@Autowired
	private CountryService �ountryService;

	@Autowired
	private TownService townService;

	@Autowired
	private HotelService hotelService;

	private static Country �ountry;
	private static Town town;
	private static Hotel hotel;

	@Before
	public void testIn() {
		int testObjectsCount = 5;
		for (int i = 0; i < testObjectsCount; i++) {
			�ountry = new Country();
			�ountry.name = ("name" + i);
			�ountryService.save(�ountry);
			town = new Town();
			town.name = ("town" + i);
			town.country = �ountry;
			townService.save(town);
			hotel = new Hotel();
			hotel.name = ("hotel" + i);
			hotel.town = town;
			hotelService.save(hotel);
		}
	}

	@After
	public void testOut() {
		hotelService.deleteAll();
		townService.deleteAll();
		�ountryService.deleteAll();
	}

	@Test
	public void test() {
		Assert.assertNotNull(�ountryService);
	}
}
