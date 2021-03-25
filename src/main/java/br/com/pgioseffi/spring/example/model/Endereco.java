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
@SuperBuilder(builderMethodName = "novoEndereco")
public class Endereco extends AuditableAbstractEntity implements Serializable {

	private static final long serialVersionUID = 5946338235197985643L;

	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String logradouro;
	private int numero;

}