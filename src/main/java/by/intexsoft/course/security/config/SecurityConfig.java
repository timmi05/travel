package by.intexsoft.course.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import by.intexsoft.course.security.filter.AuthenticationTokenFilter;
import by.intexsoft.course.service.TokenAuthenticationService;

/**
 * Spring Security configuration class
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers(HttpMethod.POST, "/country")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER").antMatchers(HttpMethod.PUT, "/country")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER").antMatchers(HttpMethod.POST, "/town")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER").antMatchers(HttpMethod.PUT, "/town")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER").antMatchers(HttpMethod.POST, "/hotel")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER").antMatchers(HttpMethod.PUT, "/hotel")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER").antMatchers(HttpMethod.POST, "/tour")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER").antMatchers(HttpMethod.PUT, "/tour")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER").antMatchers(HttpMethod.POST, "/managertours")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER").antMatchers(HttpMethod.POST, "/mytours")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER", "ROLE_USER").antMatchers(HttpMethod.POST, "/booking")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER", "ROLE_USER").antMatchers(HttpMethod.PUT, "/booking")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER", "ROLE_USER").and()
				.addFilterBefore(new AuthenticationTokenFilter(tokenAuthenticationService),
						UsernamePasswordAuthenticationFilter.class)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}
}
