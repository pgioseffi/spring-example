package br.com.pgioseffi.spring.example.constantes;

import java.util.Arrays;

public enum RoleName {

	USER(1L),
	ADMIN(2L),
	DIRETOR_FINANCEIRO(3L),
	GERENTE_FINANCEIRO(4L),
	ADMINISTRATIVO_FINANCEIRO(5L),
	GERENTE_CONTAS_MEDICAS(6L),
	ADMINISTRATIVO_CONTAS_MEDICAS(7L);

	private final long value;

	RoleName(final long value) {
		this.value = value;
	}

	public long getValue() {
		return this.value;
	}

	public static RoleName getRoleNameFromID(final long roleID) {
		return Arrays.stream(RoleName.values()).filter(role -> role.value == roleID).findFirst().orElse(null);
	}
}