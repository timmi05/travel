package by.intexsoft.course.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.course.model.Country;
import by.intexsoft.course.model.Hotel;
import by.intexsoft.course.model.Tour;
import by.intexsoft.course.model.Town;
import by.intexsoft.course.model.User;

/**
 * Repository for {@link Tour}
 */
public interface TourRepository extends JpaRepository<Tour, Long> {

	List<Tour> findByUser(User user);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownCountry(Country country);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTown(Town town);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotel(Hotel hotel);

	List<Tour> findByBookingIsNullAndArchiveFalseAndCountry(Country country);

	List<Tour> findByBookingIsNullAndArchiveFalseAndTown(Town town);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotTrue();

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndStartDateAfter(Country country, Date startDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownAndStartDateAfter(Town town, Date startDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelAndStartDateAfter(Hotel hotel, Date startDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndCountryAndStartDateAfter(Country country, Date startDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndTownAndStartDateAfter(Town town, Date startDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotTrueAndStartDateAfter(Date startDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndEndDateBefore(Country country, Date endDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownAndEndDateBefore(Town town, Date endDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelAndEndDateBefore(Hotel hotel, Date endDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndCountryAndEndDateBefore(Country country, Date endDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndTownAndEndDateBefore(Town town, Date endDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotTrueAndEndDateBefore(Date endDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndStartDateAfterAndEndDateBefore(Country country,
			Date startDate, Date endDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownAndStartDateAfterAndEndDateBefore(Town town, Date startDate,
			Date endDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelAndStartDateAfterAndEndDateBefore(Hotel hotel, Date startDate,
			Date endDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndCountryAndStartDateAfterAndEndDateBefore(Country country,
			Date startDate, Date endDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndTownAndStartDateAfterAndEndDateBefore(Town town, Date startDate,
			Date endDate);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotTrueAndStartDateAfterAndEndDateBefore(Date startDate,
			Date endDate);

	List<Tour> findByHotTrueAndBookingIsNullAndArchiveFalseAndCountry(Country country);

	List<Tour> findByHotTrueAndBookingIsNullAndArchiveFalseAndTown(Town town);

	List<Tour> findByHotTrueAndBookingIsNullAndArchiveFalseAndHotel(Hotel hotel);

	// List<Tour> findByHotTrueAndCounry();
	//
	// List<Tour> findByHotTrueAndTown();
	//
	// List<Tour> findByHotTrueAndHotel();

}
