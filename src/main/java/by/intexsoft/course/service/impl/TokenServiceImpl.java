package by.intexsoft.course.service.impl;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import by.intexsoft.course.model.User;
import by.intexsoft.course.service.TokenService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImpl implements TokenService {

	private String secretKey = "creck";

	@Override
	public String generate(User user, String password) {
		if (user != null) {
			Map<String, Object> tokenData = new HashMap<>();
			if (password.equals(user.password)) {
				tokenData.put("username", user.username);
				tokenData.put("password", user.password);
				tokenData.put("token_create_date", LocalDateTime.now());
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MINUTE, 60);
				tokenData.put("token_expiration_date", calendar.getTime());
				JwtBuilder jwtBuilder = Jwts.builder();
				jwtBuilder.setExpiration(calendar.getTime());
				jwtBuilder.setClaims(tokenData);
				return jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey).compact();
			}
		}
		return null;
	}
}
