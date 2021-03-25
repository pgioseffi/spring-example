package br.com.pgioseffi.spring.example.dto;

import java.math.BigDecimal;

import br.com.pgioseffi.spring.example.constantes.Operacao;
import br.com.pgioseffi.spring.example.constantes.Operadora;
import br.com.pgioseffi.spring.example.constantes.Status;
import br.com.pgioseffi.spring.example.constantes.TipoFatura;
import br.com.pgioseffi.spring.example.constantes.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "novoPlano")
public class PlanoDTO extends BaseDTO {

	private int ddd;
	private int diaVenctoBoleto;
	private char fidelizado;
	private String numTelefone;
	private Operacao operacao;
	private Operadora operadora;
	private Status status;
	private TipoFatura tipoFatura;
	private TipoPagamento tipoPagamento;
	private BigDecimal valorDescontoFidelizacao;
	private BigDecimal valorTotal;

}