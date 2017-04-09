package by.intexsoft.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Town;
import by.intexsoft.course.repository.TownRepository;
import by.intexsoft.course.service.TownService;

/**
 * It used to implement the techniques {@link TownService}
 */
@Service
public class TownServiceImpl implements TownService {

	@Autowired
	private TownRepository townRepository;

	@Override
	public List<Town> findAll() {
		return townRepository.findAll(new Sort("name"));
	}

	@Override
	public Town findByName(String name) {
		return townRepository.findByName(name);
	}

	@Override
	public List<Town> findByCountry(Country country) {
		return townRepository.findByCountry(country);
	}

	@Override
	public Town save(Town town) {
		return townRepository.saveAndFlush(town);
	}

	@Override
	public Town update(Town town) {
		return townRepository.saveAndFlush(town);
	}

	@Override
	public void deleteAll() {
		townRepository.deleteAll();
	}
}
