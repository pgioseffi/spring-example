package br.com.pgioseffi.spring.example.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2342297450481903870L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(final String message) {
		super(message);
	}

	public UserNotFoundException(final UUID id) {
		this(String.format("Não foi possível encontrar o usuário com id = %s.", id.toString()));
	}

	public UserNotFoundException(final Throwable cause) {
		super(cause);
	}

	public UserNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}