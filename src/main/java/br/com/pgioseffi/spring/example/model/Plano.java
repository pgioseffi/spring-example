package br.com.pgioseffi.spring.example.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;

import br.com.pgioseffi.spring.example.constantes.Operacao;
import br.com.pgioseffi.spring.example.constantes.Operadora;
import br.com.pgioseffi.spring.example.constantes.Status;
import br.com.pgioseffi.spring.example.constantes.TipoFatura;
import br.com.pgioseffi.spring.example.constantes.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "novoPlano")
public class Plano extends AuditableAbstractEntity implements Serializable {

	private static final long serialVersionUID = 7018182468333256998L;

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