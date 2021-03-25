package br.com.pgioseffi.spring.example.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pgioseffi.spring.example.exception.RegistroVendaNotFoundException;
import br.com.pgioseffi.spring.example.model.RegistroVenda;
import br.com.pgioseffi.spring.example.repository.RegistroVendaRepository;
import br.com.pgioseffi.spring.example.service.RegistroVendaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistroVendaServiceImpl implements RegistroVendaService {

	private final RegistroVendaRepository repository;

	@Override
	public Optional<RegistroVenda> buscarRegistroVenda(final UUID id) {
		return this.repository.findById(id);
	}

	@Override
	public Optional<RegistroVenda> buscarRegistroVenda(final String id) {
		return this.buscarRegistroVenda(UUID.fromString(id));
	}

	@Override
	public RegistroVenda buscarRegistroVendaObrigatoriamente(final UUID id) {
		return this.buscarRegistroVenda(id).orElseThrow(() -> new RegistroVendaNotFoundException(id));
	}

	@Override
	public RegistroVenda buscarRegistroVendaObrigatoriamente(final String id) {
		return this.buscarRegistroVendaObrigatoriamente(UUID.fromString(id));
	}

	@Override
	@Transactional
	public RegistroVenda novoRegistroVenda(final RegistroVenda registroVenda) {
		final var id = registroVenda.getId();
		return this.repository.save(id != null ? this.buscarRegistroVenda(id).orElseGet(RegistroVenda::new) : new RegistroVenda());
	}
}