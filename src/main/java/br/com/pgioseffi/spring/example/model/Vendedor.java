package br.com.pgioseffi.spring.example.model;

import java.io.Serializable;

import javax.persistence.Entity;

import br.com.pgioseffi.spring.example.constantes.Estado;
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
@SuperBuilder(builderMethodName = "novoVendedor")
public class Vendedor extends AuditableAbstractEntity implements Serializable {

	private static final long serialVersionUID = 5512283581004263001L;

	private long codigoFilial;
	private String cpf;
	private int dddFilial;
	private Estado estado;

}