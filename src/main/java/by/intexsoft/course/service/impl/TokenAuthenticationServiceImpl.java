package by.intexsoft.course.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.intexsoft.course.model.User;
import by.intexsoft.course.model.UserAuthentication;
import by.intexsoft.course.security.exception.UserNotFoundException;
import by.intexsoft.course.service.TokenAuthenticationService;
import by.intexsoft.course.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

@Service
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

//	@Value("security.token.secret.key")
	private String secretKey = "creck";

	private final static String AUTH_HEADER_NAME = "x-auth-token";

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(HttpServletRequest request) {
		String token = request.getHeader(AUTH_HEADER_NAME);
		if (token != null) {
			final Jws<Claims> tokenData = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			User user = getUserFromToken(tokenData);
			if (validatePassword(tokenData, user)) {
				return new UserAuthentication(user);
			}
		}
		return null;
	}

	private User getUserFromToken(Jws<Claims> tokenData) {
		try {
			return userService.findByUsername(tokenData.getBody().get("username").toString());
		} catch (UsernameNotFoundException e) {
			throw new UserNotFoundException("User:" + tokenData.getBody().get("username").toString() + " not found");
		}
	}

	private Boolean validatePassword(Jws<Claims> tokenData, User user) {
		if (user != null) {
			String tokenPassword = tokenData.getBody().get("password").toString();
			if (user.password.equals(tokenPassword)) {
				return true;
			}
		}
		return false;
	}
}
