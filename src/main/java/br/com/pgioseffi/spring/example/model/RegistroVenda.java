package br.com.pgioseffi.spring.example.model;

import java.io.Serializable;

import javax.persistence.Entity;

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
@SuperBuilder(builderMethodName = "novoRegistroVenda")
public class RegistroVenda extends AuditableAbstractEntity implements Serializable {

	private static final long serialVersionUID = -4472004056224593026L;

	private Aparelho aparelho;
	private Campanha campanha;
	private Cliente cliente;
	private DadosBancarios dadosBancariosDebitoAutomatico;
	private Endereco endereco;
	private Info info;
	private Plano plano;
	private Vendedor vendedor;

}