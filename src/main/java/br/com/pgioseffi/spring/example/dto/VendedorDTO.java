package br.com.pgioseffi.spring.example.dto;

import br.com.pgioseffi.spring.example.constantes.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "novoVendedor")
public class VendedorDTO extends BaseDTO {

	private long codigoFilial;
	private String cpf;
	private int dddFilial;
	private Estado estado;

}