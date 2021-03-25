package br.com.pgioseffi.spring.example.model;

import java.io.Serializable;
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
@SuperBuilder(builderMethodName = "novoCliente")
public class Cliente extends AuditableAbstractEntity implements Serializable {

	private static final long serialVersionUID = 6080522306721240955L;

	private String cpf;
	private LocalDateTime dataNascimento;
	private int ddd;
	private String email;
	private String nomeCliente;
	private String numTelefone;

}