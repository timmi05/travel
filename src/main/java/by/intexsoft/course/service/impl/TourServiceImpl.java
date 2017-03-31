package by.intexsoft.course.service.impl;

import java.util.Calendar;
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

	@Override
	public List<Tour> findTours(Tour tour) {
		if (tour.hotel != null && tour.startDate != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelAndStartDateAfterAndEndDateBefore(
					tour.hotel, tour.startDate, tour.endDate);
		}
		if (tour.town != null && tour.startDate != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownAndStartDateAfterAndEndDateBefore(
					tour.town, tour.startDate, tour.endDate);
		}
		if (tour.country != null && tour.startDate != null && tour.endDate != null) {
			return tourRepository
					.findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndStartDateAfterAndEndDateBefore(
							tour.country, tour.startDate, tour.endDate);
		}
		if (tour.startDate != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndStartDateAfterAndEndDateBefore(tour.startDate,
					tour.endDate);
		}
		if (tour.hotel != null && tour.startDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelAndStartDateAfter(tour.hotel,
					tour.startDate);
		}
		if (tour.town != null && tour.startDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownAndStartDateAfter(tour.town,
					tour.startDate);
		}
		if (tour.country != null && tour.startDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndStartDateAfter(
					tour.country, tour.startDate);
		}
		if (tour.hotel != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelAndEndDateBefore(tour.hotel, tour.endDate);
		}
		if (tour.town != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownAndEndDateBefore(tour.town,
					tour.endDate);
		}
		if (tour.country != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndEndDateBefore(
					tour.country, tour.endDate);
		}
		if (tour.hotel != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotel(tour.hotel);
		}
		if (tour.town != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTown(tour.town);
		}
		if (tour.town != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownCountry(tour.country);
		}
		return tourRepository.findByBookingIsNullAndArchiveFalse();
	}

	// @Override
	// public Tour findByName(String name) {
	// return tourRepository.findByName(name);
	// }

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

		Calendar cal = Calendar.getInstance();
		cal.setTime(tour.startDate);
		cal.add(Calendar.DATE, tour.nights);
		tour.endDate = cal.getTime();
		tour.archive = false;
		tour.hot = false;
		tour.paid = false;
		tour.used = false;
		return tourRepository.saveAndFlush(tour);
	}

	@Override
	public Tour update(Tour tour) {
		return tourRepository.saveAndFlush(tour);
	}

	@Override
	public void deleteAll() {
		tourRepository.deleteAll();
	}
}
