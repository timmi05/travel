package by.intexsoft.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Hotel;
import by.intexsoft.course.model.Tour;
import by.intexsoft.course.model.Town;
import by.intexsoft.course.model.User;
import by.intexsoft.course.repository.TourRepository;
import by.intexsoft.course.service.TourService;

/**
 * It used to implement the techniques {@link TourService}
 */
@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourRepository tourRepository;

	@Override
	public List<Tour> findAll() {
		return tourRepository.findAll();
	}

//	@Override
//	public Tour findByName(String name) {
//		return tourRepository.findByName(name);
//	}

	@Override
	public List<Tour> findByUser(User user) {
		return tourRepository.findByUser(user);
	}

	@Override
	public List<Tour> findByHotelTownCountry(Country country) {
		return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownCountry(country);
	}

	@Override
	public List<Tour> findByHotelTown(Town town) {
		return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTown(town);
	}

	@Override
	public List<Tour> findByHotel(Hotel hotel) {
		return tourRepository.findByBookingIsNullAndArchiveFalseAndHotel(hotel);
	}

	@Override
	public List<Tour> findByCountry(Country country) {
		return tourRepository.findByBookingIsNullAndArchiveFalseAndCountry(country);
	}

	@Override
	public List<Tour> findByTown(Town town) {
		return tourRepository.findByBookingIsNullAndArchiveFalseAndTown(town);
	}

	@Override
	public Tour save(Tour tour) {
		return tourRepository.saveAndFlush(tour);
	}

	@Override
	public void deleteAll() {
		tourRepository.deleteAll();
	}
}
