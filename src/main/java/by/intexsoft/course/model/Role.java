package by.intexsoft.course.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Model for {@link User} role table
 */
@Entity
@Table(name = "roles")
public class Role extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = -2482110092389856360L;

	/**
	 * Name of {@link User} role
	 */
	@Column()
	public String name;

	@ManyToMany(mappedBy = "roles")
	public Set<User> users;
}
