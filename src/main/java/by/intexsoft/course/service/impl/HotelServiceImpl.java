package by.intexsoft.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Hotel;
import by.intexsoft.course.model.Town;
import by.intexsoft.course.repository.HotelRepository;
import by.intexsoft.course.service.HotelService;

/**
 * It used to implement the techniques {@link HotelService}
 */
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public List<Hotel> findAll() {
		return hotelRepository.findAll(new Sort("name"));
	}

	@Override
	public Hotel findByName(String name) {
		return hotelRepository.findByName(name);
	}

	@Override
	public List<Hotel> findByTownCountry(Country country) {
		return hotelRepository.findByTownCountry(country);
	}

	@Override
	public List<Hotel> findByTown(Town town) {
		return hotelRepository.findByTown(town);
	}

	@Override
	public Hotel save(Hotel hotel) {
		return hotelRepository.saveAndFlush(hotel);
	}

	@Override
	public Hotel update(Hotel hotel) {
		return hotelRepository.saveAndFlush(hotel);
	}

	@Override
	public void deleteAll() {
		hotelRepository.deleteAll();
	}
}
