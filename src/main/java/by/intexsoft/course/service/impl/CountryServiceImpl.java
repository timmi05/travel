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
	private CountryRepository �ountryRepository;

	@Override
	public List<Country> findAll() {
		return �ountryRepository.findAll();
	}

	@Override
	public void save(Country country) {
		�ountryRepository.save(country);
	}
}
