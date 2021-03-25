package br.com.pgioseffi.spring.example.exception;

import java.util.UUID;

public class PreVendaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2342297450481903870L;

	public PreVendaNotFoundException() {
		super();
	}

	public PreVendaNotFoundException(final String message) {
		super(message);
	}

	public PreVendaNotFoundException(final UUID id) {
		this(String.format("Não foi possível encontrar a pré-venda com id = %s.", id.toString()));
	}

	public PreVendaNotFoundException(final Throwable cause) {
		super(cause);
	}

	public PreVendaNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public PreVendaNotFoundException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}