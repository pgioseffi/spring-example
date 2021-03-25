package br.com.pgioseffi.spring.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "novoRegistroVenda")
public class RegistroVendaDTO extends BaseDTO {

	private AparelhoDTO aparelho;
	private CampanhaDTO campanha;
	private ClienteDTO cliente;
	private DadosBancariosDTO dadosBancariosDebitoAutomatico;
	private EnderecoDTO endereco;
	private InfoDTO info;
	private PlanoDTO plano;
	private VendedorDTO vendedor;

}