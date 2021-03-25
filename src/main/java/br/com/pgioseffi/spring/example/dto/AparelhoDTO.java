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
@SuperBuilder(builderMethodName = "novoAparelho")
public class AparelhoDTO extends BaseDTO {

	private String descricao;
	private String modelo;
	private BigDecimal precoComDesconto;
	private BigDecimal precoSemDesconto;
	private long sku;

}