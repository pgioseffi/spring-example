package br.com.pgioseffi.spring.example.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "novaCampanha")
public class CampanhaDTO extends BaseDTO {

	private String campanhaTriangulacao;
	private BigDecimal descontoTriangulacao;

}