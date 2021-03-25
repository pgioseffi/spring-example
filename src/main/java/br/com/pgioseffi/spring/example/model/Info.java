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
@SuperBuilder(builderMethodName = "novaInfo")
public class Info extends AuditableAbstractEntity implements Serializable {

	private static final long serialVersionUID = -8196960953128345790L;

	private LocalDateTime dataVenda;

}