package br.com.pgioseffi.spring.example.restcontroller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pgioseffi.spring.example.dto.PreVendaDTO;
import br.com.pgioseffi.spring.example.mapper.PreVendaMapper;
import br.com.pgioseffi.spring.example.service.PreVendaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sispaggpa/pre-venda/")
@RequiredArgsConstructor
class PreVendaRestController {

	private final PreVendaService service;
	private final PreVendaMapper mapper;

	@GetMapping("/prevenda/status/{id}")
	public int status(@PathVariable final String id) {
		return this.service.buscarStatusPreVenda(id);
	}

	@GetMapping("/prevenda/{id}")
	public PreVendaDTO buscarPreVenda(@PathVariable final String id) {
		return this.mapper.toPreVendaDTO(this.service.buscarPreVendaObrigatoriamente(id));
	}

	@GetMapping("/prevenda/todas")
	public Collection<PreVendaDTO> buscarTodasPreVendas() {
		return this.service.buscarTodasPreVendasOrdenadas().stream().map(pv -> this.mapper.toPreVendaDTO(pv)).collect(Collectors.toList());
	}
}