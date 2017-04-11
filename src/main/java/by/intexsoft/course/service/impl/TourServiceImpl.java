package by.intexsoft.course.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	public List<Tour> findForArchive() {
		return tourRepository.findByArchiveFalse();
	}

	@Override
	public List<Tour> findTours(Tour tour) {
		if (tour.endDate != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(tour.endDate);
			calendar.add(Calendar.HOUR, 13);
			tour.endDate = calendar.getTime();
		}
		if (tour.hotel != null && tour.startDate != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelAndStartDateAfterAndEndDateBefore(
					tour.hotel, tour.startDate, tour.endDate, new Sort("startDate"));
		}
		if (tour.town != null && tour.startDate != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownAndStartDateAfterAndEndDateBefore(
					tour.town, tour.startDate, tour.endDate, new Sort("startDate"));
		}
		if (tour.country != null && tour.startDate != null && tour.endDate != null) {
			return tourRepository
					.findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndStartDateAfterAndEndDateBefore(
							tour.country, tour.startDate, tour.endDate, new Sort("startDate"));
		}
		if (tour.startDate != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndStartDateAfterAndEndDateBefore(tour.startDate,
					tour.endDate, new Sort("startDate"));
		}
		if (tour.hotel != null && tour.startDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelAndStartDateAfter(tour.hotel,
					tour.startDate, new Sort("startDate"));
		}
		if (tour.town != null && tour.startDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownAndStartDateAfter(tour.town,
					tour.startDate, new Sort("startDate"));
		}
		if (tour.country != null && tour.startDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndStartDateAfter(tour.country,
					tour.startDate, new Sort("startDate"));
		}
		if (tour.hotel != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelAndEndDateBefore(tour.hotel, tour.endDate,
					new Sort("startDate"));
		}
		if (tour.town != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownAndEndDateBefore(tour.town,
					tour.endDate, new Sort("startDate"));
		}
		if (tour.country != null && tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndEndDateBefore(tour.country,
					tour.endDate, new Sort("startDate"));
		}
		if (tour.hotel != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotel(tour.hotel, new Sort("startDate"));
		}
		if (tour.town != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTown(tour.town, new Sort("startDate"));
		}
		if (tour.country != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownCountry(tour.country,
					new Sort("startDate"));
		}
		if (tour.startDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndStartDateAfter(tour.startDate,
					new Sort("startDate"));
		}
		if (tour.endDate != null) {
			return tourRepository.findByBookingIsNullAndArchiveFalseAndEndDateBefore(tour.endDate,
					new Sort("startDate"));
		}
		return tourRepository.findByBookingIsNullAndArchiveFalse(new Sort("startDate"));
	}

	@Override
	public List<Tour> findToursForManager(Tour tour) {
		if (tour.endDate != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(tour.endDate);
			calendar.add(Calendar.HOUR, 13);
			tour.endDate = calendar.getTime();
		}
		if (tour.hotel != null && tour.startDate != null && tour.endDate != null) {
			return tourRepository.findByArchiveFalseAndHotelAndStartDateAfterAndEndDateBefore(tour.hotel,
					tour.startDate, tour.endDate, new Sort("startDate"));
		}
		if (tour.town != null && tour.startDate != null && tour.endDate != null) {
			return tourRepository.findByArchiveFalseAndHotelTownAndStartDateAfterAndEndDateBefore(tour.town,
					tour.startDate, tour.endDate, new Sort("startDate"));
		}
		if (tour.country != null && tour.startDate != null && tour.endDate != null) {
			return tourRepository.findByArchiveFalseAndHotelTownCountryAndStartDateAfterAndEndDateBefore(tour.country,
					tour.startDate, tour.endDate, new Sort("startDate"));
		}
		if (tour.startDate != null && tour.endDate != null) {
			return tourRepository.findByArchiveFalseAndStartDateAfterAndEndDateBefore(tour.startDate, tour.endDate,
					new Sort("startDate"));
		}
		if (tour.hotel != null && tour.startDate != null) {
			return tourRepository.findByArchiveFalseAndHotelAndStartDateAfter(tour.hotel, tour.startDate,
					new Sort("startDate"));
		}
		if (tour.town != null && tour.startDate != null) {
			return tourRepository.findByArchiveFalseAndHotelTownAndStartDateAfter(tour.town, tour.startDate,
					new Sort("startDate"));
		}
		if (tour.country != null && tour.startDate != null) {
			return tourRepository.findByArchiveFalseAndHotelTownCountryAndStartDateAfter(tour.country, tour.startDate,
					new Sort("startDate"));
		}
		if (tour.hotel != null && tour.endDate != null) {
			return tourRepository.findByArchiveFalseAndHotelAndEndDateBefore(tour.hotel, tour.endDate,
					new Sort("startDate"));
		}
		if (tour.town != null && tour.endDate != null) {
			return tourRepository.findByArchiveFalseAndHotelTownAndEndDateBefore(tour.town, tour.endDate,
					new Sort("startDate"));
		}
		if (tour.country != null && tour.endDate != null) {
			return tourRepository.findByArchiveFalseAndHotelTownCountryAndEndDateBefore(tour.country, tour.endDate,
					new Sort("startDate"));
		}
		if (tour.hotel != null) {
			return tourRepository.findByArchiveFalseAndHotel(tour.hotel, new Sort("startDate"));
		}
		if (tour.town != null) {
			return tourRepository.findByArchiveFalseAndHotelTown(tour.town, new Sort("startDate"));
		}
		if (tour.country != null) {
			return tourRepository.findByArchiveFalseAndHotelTownCountry(tour.country, new Sort("startDate"));
		}
		if (tour.startDate != null) {
			return tourRepository.findByArchiveFalseAndStartDateAfter(tour.startDate, new Sort("startDate"));
		}
		if (tour.endDate != null) {
			return tourRepository.findByArchiveFalseAndEndDateBefore(tour.endDate, new Sort("startDate"));
		}
		return tourRepository.findByArchiveFalse(new Sort("startDate"));
	}

	@Override
	public List<Tour> findByUser(User user) {
		return tourRepository.findByUser(user);
	}

	@Override
	public List<Tour> findByHotelTownCountry(Country country) {
		return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTownCountry(country, new Sort("startDate"));
	}

	@Override
	public List<Tour> findByHotelTown(Town town) {
		return tourRepository.findByBookingIsNullAndArchiveFalseAndHotelTown(town, new Sort("startDate"));
	}

	@Override
	public List<Tour> findByHotel(Hotel hotel) {
		return tourRepository.findByBookingIsNullAndArchiveFalseAndHotel(hotel, new Sort("startDate"));
	}

	@Override
	public List<Tour> findByCountry(Country country) {
		return tourRepository.findByBookingIsNullAndArchiveFalseAndCountry(country, new Sort("startDate"));
	}

	@Override
	public List<Tour> findByTown(Town town) {
		return tourRepository.findByBookingIsNullAndArchiveFalseAndTown(town, new Sort("startDate"));
	}

	@Override
	public Tour save(Tour tour) {

		Calendar ñalendar = Calendar.getInstance();
		ñalendar.setTime(tour.startDate);
		ñalendar.add(Calendar.HOUR, 12);
		tour.startDate = ñalendar.getTime();
		ñalendar.add(Calendar.DATE, tour.nights);
		tour.endDate = ñalendar.getTime();
		tour.archive = false;
		tour.paid = false;
		tour.used = false;
		return tourRepository.saveAndFlush(tour);
	}

	@Override
	public Tour update(Tour tour) {
		return tourRepository.saveAndFlush(tour);
	}

	@Override
	public Tour findById(Long id) {
		return tourRepository.findOne(id);
	}

	@Override
	public Tour booking(Tour tour) {
		Tour bookingTour = findById(tour.id);
		if (bookingTour.booking == null) {
			bookingTour.user = tour.user;
			bookingTour.booking = new Date();
			return tourRepository.saveAndFlush(bookingTour);
		} else {
			return null;
		}
	}

	@Override
	public Tour unBooking(Tour tour) {
		Tour unBookingTour = findById(tour.id);
		unBookingTour.user = null;
		unBookingTour.booking = null;
		return tourRepository.saveAndFlush(unBookingTour);
	}

	@Override
	public void deleteAll() {
		tourRepository.deleteAll();
	}
}
