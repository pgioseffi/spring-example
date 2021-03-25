package br.com.pgioseffi.spring.example.service.impl;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pgioseffi.spring.example.exception.PreVendaNotFoundException;
import br.com.pgioseffi.spring.example.model.PreVenda;
import br.com.pgioseffi.spring.example.repository.PreVendaRepository;
import br.com.pgioseffi.spring.example.service.PreVendaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PreVendaServiceImpl implements PreVendaService {

	private final PreVendaRepository repository;

	@Override
	public Optional<PreVenda> buscarPreVenda(final UUID id) {
		return this.repository.findById(id);
	}

	@Override
	public Optional<PreVenda> buscarPreVenda(final String id) {
		return this.buscarPreVenda(UUID.fromString(id));
	}

	@Override
	public PreVenda buscarPreVendaObrigatoriamente(final UUID id) {
		return this.buscarPreVenda(id).orElseThrow(() -> new PreVendaNotFoundException(id));
	}

	@Override
	public PreVenda buscarPreVendaObrigatoriamente(final String id) {
		return this.buscarPreVendaObrigatoriamente(UUID.fromString(id));
	}

	@Override
	public int buscarStatusPreVenda(final UUID id) {
		return this.buscarPreVendaObrigatoriamente(id).getStatus();
	}

	@Override
	public int buscarStatusPreVenda(final String id) {
		return this.buscarPreVendaObrigatoriamente(id).getStatus();
	}

	@Override
	@Transactional
	public PreVenda novaPreVenda(final PreVenda preVenda) {
		final var id = preVenda.getId();
		return this.repository.save(id != null ? this.buscarPreVenda(id).orElseGet(PreVenda::new) : new PreVenda());
	}

	@Override
	public Collection<PreVenda> buscarTodasPreVendasOrdenadas() {
		return this.repository.findAll(Sort.by("createdDate"));
	}
}