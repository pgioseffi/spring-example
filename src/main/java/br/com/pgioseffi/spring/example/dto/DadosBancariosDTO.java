package br.com.pgioseffi.spring.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "novosDadosBancarios")
public class DadosBancariosDTO extends BaseDTO {

	private int agencia;
	private int conta;
	private int digitoAgencia;
	private int digitoConta;
	private int idBanco;

}