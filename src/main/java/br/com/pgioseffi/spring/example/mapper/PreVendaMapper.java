package br.com.pgioseffi.spring.example.mapper;

import org.mapstruct.Mapper;

import br.com.pgioseffi.spring.example.dto.PreVendaDTO;
import br.com.pgioseffi.spring.example.model.PreVenda;

@Mapper
public interface PreVendaMapper {

	PreVendaDTO toPreVendaDTO(PreVenda preVenda);

	PreVenda toPreVenda(PreVendaDTO preVendaDTO);

}