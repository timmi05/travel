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
import by.intexsoft.course.service.CountryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context-test.xml" })
public class CountryServiceTest {

	@Autowired
	private CountryService ñountryService;

	private static Country ñountry;

	@Before
	public void testIn() {
		int testObjectsCount = 6;
		for (int i = 0; i < testObjectsCount; i++) {
			ñountry = new Country();
			ñountry.name = ("name" + i);
			ñountryService.save(ñountry);
		}
	}

	@After
	public void testOut() {
		ñountryService.deleteAll();
	}

	@Test
	public void test() {
		Assert.assertNotNull(ñountryService);
	}
}
