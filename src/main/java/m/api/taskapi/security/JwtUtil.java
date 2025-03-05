package m.api.taskapi.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
	private Key secretKey;
	private static final long EXPIRATION_TIME = 86400000; // 1 day

	@PostConstruct
	public void init() {
		secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	}

	public String generateToken(String email) {
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(secretKey, SignatureAlgorithm.HS256)
				.compact();
	}

	public String getEmailFromToken(String token) {
		return Jwts.parser().setSigningKey(secretKey).build()
				.parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

