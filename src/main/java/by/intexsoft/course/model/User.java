package by.intexsoft.course.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Model for users table
 */
@Entity
@Table(name = "users")
public class User extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 7232927597102396226L;

	/**
	 * Name of user
	 */
	@Column
	public String username;

	/**
	 * Password of user
	 */
	@Column
	public String password;

	@Transient
	public String confirmPassword;

	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
}
