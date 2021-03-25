package br.com.pgioseffi.spring.example.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "novaPreVenda")
public class PreVendaDTO extends BaseDTO {

	private long codigoAparelho;
	private long codigoLoja;
	private String cpf;
	private LocalDateTime dataVenda;
	private BigDecimal descontoTriangulacao;
	private int status;

}