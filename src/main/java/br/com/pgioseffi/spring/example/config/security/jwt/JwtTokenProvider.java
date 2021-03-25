package br.com.pgioseffi.spring.example.config.security.jwt;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import br.com.pgioseffi.spring.example.config.security.model.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);
	private static final String CLAIM_KEY_CREATED = "created";

	@Value("${app.jwtSecret}")
	private String jwtSecret;

	@Value("${app.jwtExpirationInMs}")
	private int jwtExpirationInMs;

	public String generateToken(final Authentication authentication) {
		return Jwts.builder().setSubject(((UserPrincipal) authentication.getPrincipal()).getId().toString()).setIssuedAt(new Date()).setExpiration(this.getExpiryDate())
				.signWith(SignatureAlgorithm.HS512, this.jwtSecret).compact();
	}

	private Date getExpiryDate() {
		return new Date(new Date().getTime() + this.jwtExpirationInMs);
	}

	private Claims getClaimsFromToken(final String aTokenContext) {
		try {
			return Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(aTokenContext).getBody();
		} catch (final ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
			JwtTokenProvider.LOGGER.error(String.format("Erro ao setar chave de assinatura. ERRO: %s.", e.getMessage()), e);
			return null;
		}
	}

	public String refreshToken(final String a_tkContext) {
		try {
			final var currentClaim = this.getClaimsFromToken(a_tkContext);
			currentClaim.put(JwtTokenProvider.CLAIM_KEY_CREATED, new Date());
			return Jwts.builder().setClaims((Map<String, Object>) currentClaim).setExpiration(this.getExpiryDate()).signWith(SignatureAlgorithm.HS512, this.jwtSecret).compact();
		} catch (final Exception e) {
			JwtTokenProvider.LOGGER.error(String.format("Erro ao atualizar token. ERRO: %s.", e.getMessage()), e);
			return null;
		}
	}

	public UUID getUserIdFromJWT(final String token) {
		return UUID.fromString(Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(token).getBody().getSubject());
	}

	public boolean validateToken(final String authToken) {
		try {
			Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (final SignatureException e) {
			JwtTokenProvider.LOGGER.error("Invalid JWT signature", e);
		} catch (final MalformedJwtException e) {
			JwtTokenProvider.LOGGER.error("Invalid JWT token", e);
		} catch (final ExpiredJwtException e) {
			JwtTokenProvider.LOGGER.error("Expired JWT token", e);
		} catch (final UnsupportedJwtException e) {
			JwtTokenProvider.LOGGER.error("Unsupported JWT token", e);
		} catch (final IllegalArgumentException e) {
			JwtTokenProvider.LOGGER.error("JWT claims string is empty.", e);
		}

		return false;
	}
}