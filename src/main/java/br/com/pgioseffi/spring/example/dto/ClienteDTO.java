package br.com.pgioseffi.spring.example.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "novoCliente")
public class ClienteDTO extends BaseDTO {

	private String cpf;
	private LocalDateTime dataNascimento;
	private int ddd;
	private String email;
	private String nomeCliente;
	private String numTelefone;

}