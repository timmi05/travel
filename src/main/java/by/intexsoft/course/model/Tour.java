package by.intexsoft.course.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Model for tours table
 */
@Entity
@Table(name = "tours")
public class Tour extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = -782215207665987375L;

	/**
	 * {@link Hotel} for the tour
	 */
	@ManyToOne(targetEntity = Hotel.class, fetch = FetchType.LAZY)
	public Hotel hotel;

	/**
	 * {@link Town} for the tour
	 */
	@ManyToOne(targetEntity = Town.class, fetch = FetchType.LAZY)
	public Town town;

	/**
	 * {@link Country} for the tour
	 */
	@ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY)
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
	@Column
	public Date start;

	/**
	 * End date of the tour
	 */
	@Column
	public Date end;

	/**
	 * Hot tour
	 */
	@Column
	public Boolean hot;

	/**
	 * {@link Country} for the tour
	 */
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
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
