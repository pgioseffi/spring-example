package br.com.pgioseffi.spring.example.service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import br.com.pgioseffi.spring.example.model.PreVenda;

public interface PreVendaService {

	Optional<PreVenda> buscarPreVenda(UUID id);

	Optional<PreVenda> buscarPreVenda(String id);

	PreVenda buscarPreVendaObrigatoriamente(UUID id);

	PreVenda buscarPreVendaObrigatoriamente(String id);

	PreVenda novaPreVenda(PreVenda preVenda);

	int buscarStatusPreVenda(UUID id);

	int buscarStatusPreVenda(String id);

	Collection<PreVenda> buscarTodasPreVendasOrdenadas();

}