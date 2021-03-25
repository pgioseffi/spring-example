package br.com.pgioseffi.spring.example.restcontroller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pgioseffi.spring.example.dto.PreVendaDTO;
import br.com.pgioseffi.spring.example.model.RegistroVenda;
import br.com.pgioseffi.spring.example.service.RegistroVendaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sispaggpa/registro-venda/")
@RequiredArgsConstructor
class RegistroVendaRestController {

	private final RegistroVendaService service;
	private final ModelMapper mapper;

	@PatchMapping("/registrar-venda")
	public PreVendaDTO novaPrevenda(@RequestBody @Valid final RegistroVenda novoRegistroVenda) {
		return this.mapper.map(this.service.novoRegistroVenda(novoRegistroVenda), PreVendaDTO.class);
	}
}