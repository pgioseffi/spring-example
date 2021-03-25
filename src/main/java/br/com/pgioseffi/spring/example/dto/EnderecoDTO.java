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
@SuperBuilder(builderMethodName = "novoEndereco")
public class EnderecoDTO extends BaseDTO {

	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String logradouro;
	private int numero;

}