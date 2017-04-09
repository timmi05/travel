package by.intexsoft.course.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
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
	
	List<Tour> findByArchiveFalse();

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownCountry(Country country, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTown(Town town, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotel(Hotel hotel, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndCountry(Country country, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndTown(Town town, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalse(Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndStartDateAfter(Country country, Date startDate,
			Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownAndStartDateAfter(Town town, Date startDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelAndStartDateAfter(Hotel hotel, Date startDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndCountryAndStartDateAfter(Country country, Date startDate,
			Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndTownAndStartDateAfter(Town town, Date startDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotTrueAndStartDateAfter(Date startDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndEndDateBefore(Country country, Date endDate,
			Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownAndEndDateBefore(Town town, Date endDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelAndEndDateBefore(Hotel hotel, Date endDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndCountryAndEndDateBefore(Country country, Date endDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndTownAndEndDateBefore(Town town, Date endDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotTrueAndEndDateBefore(Date endDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownCountryAndStartDateAfterAndEndDateBefore(Country country,
			Date startDate, Date endDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelTownAndStartDateAfterAndEndDateBefore(Town town,
			Date startDate, Date endDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotelAndStartDateAfterAndEndDateBefore(Hotel hotel, Date startDate,
			Date endDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndCountryAndStartDateAfterAndEndDateBefore(Country country,
			Date startDate, Date endDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndTownAndStartDateAfterAndEndDateBefore(Town town, Date startDate,
			Date endDate, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndStartDateAfterAndEndDateBefore(Date startDate, Date endDate,
			Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotTrueAndStartDateAfterAndEndDateBefore(Date startDate,
			Date endDate, Sort sort);

	List<Tour> findByHotTrueAndBookingIsNullAndArchiveFalseAndCountry(Country country, Sort sort);

	List<Tour> findByHotTrueAndBookingIsNullAndArchiveFalseAndTown(Town town, Sort sort);

	List<Tour> findByHotTrueAndBookingIsNullAndArchiveFalseAndHotel(Hotel hotel, Sort sort);

	List<Tour> findByBookingIsNullAndArchiveFalseAndHotTrue(Sort sort);
	
	List<Tour> findByBookingIsNullAndArchiveFalseAndStartDateAfter(Date startDate, Sort sort);
	
	List<Tour> findByBookingIsNullAndArchiveFalseAndEndDateBefore(Date endDate, Sort sort);

	// List<Tour> findByHotTrueAndCounry();
	//
	// List<Tour> findByHotTrueAndTown();
	//
	// List<Tour> findByHotTrueAndHotel();
	List<Tour> findByArchiveFalseAndHotelTownCountry(Country country, Sort sort);

	List<Tour> findByArchiveFalseAndHotelTown(Town town, Sort sort);

	List<Tour> findByArchiveFalseAndHotel(Hotel hotel, Sort sort);

	List<Tour> findByArchiveFalseAndCountry(Country country, Sort sort);

	List<Tour> findByArchiveFalseAndTown(Town town, Sort sort);

	List<Tour> findByArchiveFalse(Sort sort);

	List<Tour> findByArchiveFalseAndHotelTownCountryAndStartDateAfter(Country country, Date startDate,
			Sort sort);

	List<Tour> findByArchiveFalseAndHotelTownAndStartDateAfter(Town town, Date startDate, Sort sort);

	List<Tour> findByArchiveFalseAndHotelAndStartDateAfter(Hotel hotel, Date startDate, Sort sort);

	List<Tour> findByArchiveFalseAndCountryAndStartDateAfter(Country country, Date startDate,
			Sort sort);

	List<Tour> findByArchiveFalseAndTownAndStartDateAfter(Town town, Date startDate, Sort sort);

	List<Tour> findByArchiveFalseAndHotTrueAndStartDateAfter(Date startDate, Sort sort);

	List<Tour> findByArchiveFalseAndHotelTownCountryAndEndDateBefore(Country country, Date endDate,
			Sort sort);

	List<Tour> findByArchiveFalseAndHotelTownAndEndDateBefore(Town town, Date endDate, Sort sort);

	List<Tour> findByArchiveFalseAndHotelAndEndDateBefore(Hotel hotel, Date endDate, Sort sort);

	List<Tour> findByArchiveFalseAndCountryAndEndDateBefore(Country country, Date endDate, Sort sort);

	List<Tour> findByArchiveFalseAndTownAndEndDateBefore(Town town, Date endDate, Sort sort);

	List<Tour> findByArchiveFalseAndHotTrueAndEndDateBefore(Date endDate, Sort sort);

	List<Tour> findByArchiveFalseAndHotelTownCountryAndStartDateAfterAndEndDateBefore(Country country,
			Date startDate, Date endDate, Sort sort);

	List<Tour> findByArchiveFalseAndHotelTownAndStartDateAfterAndEndDateBefore(Town town,
			Date startDate, Date endDate, Sort sort);

	List<Tour> findByArchiveFalseAndHotelAndStartDateAfterAndEndDateBefore(Hotel hotel, Date startDate,
			Date endDate, Sort sort);

	List<Tour> findByArchiveFalseAndCountryAndStartDateAfterAndEndDateBefore(Country country,
			Date startDate, Date endDate, Sort sort);

	List<Tour> findByArchiveFalseAndTownAndStartDateAfterAndEndDateBefore(Town town, Date startDate,
			Date endDate, Sort sort);

	List<Tour> findByArchiveFalseAndStartDateAfterAndEndDateBefore(Date startDate, Date endDate,
			Sort sort);

	List<Tour> findByArchiveFalseAndHotTrueAndStartDateAfterAndEndDateBefore(Date startDate,
			Date endDate, Sort sort);
	
	List<Tour> findByArchiveFalseAndHotTrue(Sort sort);
	
	List<Tour> findByArchiveFalseAndStartDateAfter(Date startDate, Sort sort);
	
	List<Tour> findByArchiveFalseAndEndDateBefore(Date endDate, Sort sort);

}
