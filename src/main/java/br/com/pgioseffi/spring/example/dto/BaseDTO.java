package br.com.pgioseffi.spring.example.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseDTO {

	private UUID id;

	@JsonIgnore
	protected Long createdBy;

	@JsonIgnore
	protected Date createdDate;

	@JsonIgnore
	protected Long updatedBy;

	@JsonIgnore
	@Builder.Default
	protected LocalDate updatedDate = LocalDate.now();

}