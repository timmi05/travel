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
import by.intexsoft.course.model.Town;
import by.intexsoft.course.service.CountryService;
import by.intexsoft.course.service.TownService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context-test.xml" })
public class TownServiceTest {

	@Autowired
	private CountryService ñountryService;

	@Autowired
	private TownService townService;

	private static Country ñountry;
	private static Town town;

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
		}
	}

	@After
	public void testOut() {
		townService.deleteAll();
		ñountryService.deleteAll();
	}

	@Test
	public void findByName() {
		String someTown = "town2";
		Town town = townService.findByName(someTown);
		Assert.assertNotNull(town);
	}
}
