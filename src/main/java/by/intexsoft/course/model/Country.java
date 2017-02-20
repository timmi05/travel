package by.intexsoft.course.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Model for countries table
 */
@Entity
@Table(name = "countries")
public class Country extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 1836630999531378566L;

	/**
	 * Name of country
	 */
	@Column
	public String name;
}
