package br.com.pgioseffi.spring.example.exception;

import java.util.UUID;

public class RegistroVendaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9020039330455630510L;

	public RegistroVendaNotFoundException() {
		super();
	}

	public RegistroVendaNotFoundException(final String message) {
		super(message);
	}

	public RegistroVendaNotFoundException(final UUID id) {
		this(String.format("Não foi possível encontrar o registro de venda com id = %s.", id.toString()));
	}

	public RegistroVendaNotFoundException(final Throwable cause) {
		super(cause);
	}

	public RegistroVendaNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public RegistroVendaNotFoundException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}