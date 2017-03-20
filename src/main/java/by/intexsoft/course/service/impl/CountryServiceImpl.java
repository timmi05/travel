package by.intexsoft.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.repository.CountryRepository;
import by.intexsoft.course.service.CountryService;

/**
 * It used to implement the techniques {@link CountryService}
 */
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository ñountryRepository;

	@Override
	public List<Country> findAll() {
		return ñountryRepository.findAll();
	}

	@Override
	public Country findByName(String name) {
		return ñountryRepository.findByName(name);
	}

	@Override
	public Country save(Country country) {
		return ñountryRepository.saveAndFlush(country);
	}

	@Override
	public Country update(Country country) {
		return ñountryRepository.saveAndFlush(country);
	}

	@Override
	public void deleteAll() {
		ñountryRepository.deleteAll();
	}
}
