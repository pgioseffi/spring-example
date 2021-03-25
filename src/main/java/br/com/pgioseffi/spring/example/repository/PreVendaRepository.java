package br.com.pgioseffi.spring.example.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pgioseffi.spring.example.model.PreVenda;

public interface PreVendaRepository extends JpaRepository<PreVenda, UUID> {

}