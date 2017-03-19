package by.intexsoft.course.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Model for users table
 */
@Entity
@Table(name = "users")
public class User extends AbstractModel {

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

	/**
	 * Confirm user password
	 */
	@Transient
	public String confirmPassword;

	/**
	 * First Name of user
	 */
	@Column(name = "first_name")
	public String firstName;

	/**
	 * Last Name of user
	 */
	@Column(name = "last_name")
	public String lastName;

	/**
	 * Phone number of user
	 */
	@Column(name = "phone_number")
	public String phoneNumber;

	/**
	 * E-mail of user
	 */
	@Column
	public String mail;

	/**
	 * All roles of user
	 */
	@ManyToMany(targetEntity = Authority.class, fetch = FetchType.EAGER)
	@JoinTable(name = "user_authorities", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "authority_id") })
	public List<Authority> authorities;

}
