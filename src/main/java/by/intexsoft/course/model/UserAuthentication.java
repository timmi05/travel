package by.intexsoft.course.model;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * Model representation for security
 */
public class UserAuthentication implements Authentication {

	private static final long serialVersionUID = -5400644571644743804L;

	private final User user;
	private boolean authenticated = true;

	public UserAuthentication(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.authorities;
	}

	@Override
	public Object getCredentials() {
		return user.password;
	}

	@Override
	public Object getDetails() {
		return user;
	}

	@Override
	public Object getPrincipal() {
		return user.username;
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
		this.authenticated = authenticated;
	}

	@Override
	public String getName() {
		return user.username;
	}

	public User getUser() {
		return user;
	}
}
