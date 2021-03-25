package br.com.pgioseffi.spring.example.service;

import java.util.Optional;
import java.util.UUID;

import br.com.pgioseffi.spring.example.model.RegistroVenda;

public interface RegistroVendaService {

	Optional<RegistroVenda> buscarRegistroVenda(UUID id);

	Optional<RegistroVenda> buscarRegistroVenda(String id);

	RegistroVenda buscarRegistroVendaObrigatoriamente(UUID id);

	RegistroVenda buscarRegistroVendaObrigatoriamente(String id);

	RegistroVenda novoRegistroVenda(RegistroVenda registroVendaVenda);

}