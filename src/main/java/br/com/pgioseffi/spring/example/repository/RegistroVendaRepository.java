package br.com.pgioseffi.spring.example.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pgioseffi.spring.example.model.RegistroVenda;

public interface RegistroVendaRepository extends JpaRepository<RegistroVenda, UUID> {

}