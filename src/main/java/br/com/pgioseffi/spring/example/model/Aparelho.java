package br.com.pgioseffi.spring.example.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@SuperBuilder(builderMethodName = "novoAparelho")
public class Aparelho extends AuditableAbstractEntity implements Serializable {

	private static final long serialVersionUID = 1477842666650395440L;

	private String descricao;
	private String modelo;
	private BigDecimal precoComDesconto;
	private BigDecimal precoSemDesconto;
	private long sku;

}