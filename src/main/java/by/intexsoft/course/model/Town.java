package by.intexsoft.course.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model for towns table
 */
@Entity
@Table(name = "towns")
public class Town extends AbstractModel {

	private static final long serialVersionUID = -2615442138605554144L;

	/**
	 * Name of town
	 */
	@Column
	public String name;

	/**
	 * {@link Country} in which the town is located
	 */
	@ManyToOne(targetEntity = Country.class, fetch = FetchType.EAGER)
	public Country country;

}
