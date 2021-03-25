package br.com.pgioseffi.spring.example.constantes;

public final class Constantes {

	public static final String BEARER_PREFIX = "Bearer ";
	public static final String TOKEN_HEADER = "Authorization";

	private Constantes() {
		throw new AssertionError("Não é permitido instanciar a classe de constantes.");
	}
}