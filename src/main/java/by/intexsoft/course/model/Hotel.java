package by.intexsoft.course.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model for hotels table
 */
@Entity
@Table(name = "hotels")
public class Hotel extends AbstractModel {

	private static final long serialVersionUID = -6108533233304560675L;

	/**
	 * Name of hotel
	 */
	@Column
	public String name;

	/**
	 * Address of hotel
	 */
	@Column
	public String address;

	/**
	 * {@link Town} in which the hotel is located
	 */
	@ManyToOne(targetEntity = Town.class, fetch = FetchType.EAGER)
	public Town town;
}
