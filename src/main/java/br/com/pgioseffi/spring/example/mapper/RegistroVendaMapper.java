package br.com.pgioseffi.spring.example.mapper;

import org.mapstruct.Mapper;

import br.com.pgioseffi.spring.example.dto.RegistroVendaDTO;
import br.com.pgioseffi.spring.example.model.RegistroVenda;

@Mapper
public interface RegistroVendaMapper {

	RegistroVendaDTO toRegistroVendaDTO(RegistroVenda registroVenda);

	RegistroVenda toRegistroVenda(RegistroVendaDTO registroVendaDTO);

}