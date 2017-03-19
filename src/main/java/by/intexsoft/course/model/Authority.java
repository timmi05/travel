package by.intexsoft.course.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model for {@link User} role table
 */
@Entity
@Table(name = "authorities")
public class Authority extends AbstractModel implements GrantedAuthority {

	private static final long serialVersionUID = -2482110092389856360L;

	/**
	 * Name of {@link User} role
	 */
	@Column
	public String authority;

	@Override
	//@JsonIgnore
	public String getAuthority() {
		return authority;
	}
}
