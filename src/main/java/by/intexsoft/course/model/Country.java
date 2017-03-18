package by.intexsoft.course.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Model for countries table
 */
@Entity
@Table(name = "countries")
public class Country extends AbstractModel{

	private static final long serialVersionUID = 1836630999531378566L;

	/**
	 * Name of country
	 */
	@Column
	public String name;
}
