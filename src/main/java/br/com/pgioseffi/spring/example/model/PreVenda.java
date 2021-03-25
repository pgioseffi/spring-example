package br.com.pgioseffi.spring.example.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@SuperBuilder(builderMethodName = "novaPreVenda")
public class PreVenda extends AuditableAbstractEntity implements Serializable {

	private static final long serialVersionUID = -7623196239963303184L;

	private long codigoAparelho;
	private long codigoLoja;
	private String cpf;
	private LocalDateTime dataVenda;
	private BigDecimal descontoTriangulacao;
	private int status;

}