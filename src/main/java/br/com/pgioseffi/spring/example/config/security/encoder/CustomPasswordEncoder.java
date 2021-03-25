package br.com.pgioseffi.spring.example.config.security.encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomPasswordEncoder.class);

	@Override
	public String encode(final CharSequence rawPassword) {
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("MD5");
		} catch (final NoSuchAlgorithmException e) {
			CustomPasswordEncoder.LOGGER.error("MD5 não presente no ambiente.", e);
			return null;
		}

		final var hash = md.digest(rawPassword.toString().getBytes());
		final var sb = new StringBuilder();
		for (final var element : hash) {
			sb.append(Integer.toHexString(element & 0xFF | 0x100).substring(1, 3));
		}

		return sb.toString();
	}

	@Override
	public boolean matches(final CharSequence rawPassword, final String encodedPassword) {
		return this.encode(rawPassword.toString()).equals(encodedPassword);
	}
}