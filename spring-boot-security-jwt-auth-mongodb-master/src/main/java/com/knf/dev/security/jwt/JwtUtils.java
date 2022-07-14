package com.knf.dev.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.knf.dev.security.services.EmployeeDetailsImpl;

import io.jsonwebtoken.*;

@Component
public class JwtUtils {

	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${knf.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	@Value("${knf.app.jwtSecret}")
	private String jwtSecret;

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}

	public String generateJwtToken(Authentication authentication) {

		EmployeeDetailsImpl employeePrincipal = (EmployeeDetailsImpl) authentication.getPrincipal();

		return Jwts.builder().setSubject((employeePrincipal.getUsername())).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public String getEmployeeNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

}
