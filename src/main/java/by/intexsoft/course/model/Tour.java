package by.intexsoft.course.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model for tours table
 */
@Entity
@Table(name = "tours")
public class Tour extends AbstractModel {

	private static final long serialVersionUID = -782215207665987375L;

	/**
	 * {@link Hotel} for the tour
	 */
	@ManyToOne(targetEntity = Hotel.class, fetch = FetchType.EAGER)
	public Hotel hotel;

	/**
	 * {@link Town} for the tour
	 */
	@ManyToOne(targetEntity = Town.class, fetch = FetchType.EAGER)
	public Town town;

	/**
	 * {@link Country} for the tour
	 */
	@ManyToOne(targetEntity = Country.class, fetch = FetchType.EAGER)
	public Country country;

	/**
	 * Price for tour
	 */
	@Column
	public Double price;

	/**
	 * Number of nights of tour
	 */
	@Column
	public Short nights;

	/**
	 * Number of persons of tour
	 */
	@Column
	public Byte persons;

	/**
	 * Start date of the tour
	 */
	@Column(name = "start_date")
	public Date startDate;

	/**
	 * End date of the tour
	 */
	@Column(name = "end_date")
	public Date endDate;

	/**
	 * Tour for {@link User}
	 */
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	public User user;

	/**
	 * Tour used
	 */
	@Column
	public Boolean used;

	/**
	 * When the tour was booked
	 */
	@Column
	public Date booking;

	/**
	 * Tour paid
	 */
	@Column
	public Boolean paid;

	/**
	 * Tour at archive
	 */
	@Column
	public Boolean archive;
}
