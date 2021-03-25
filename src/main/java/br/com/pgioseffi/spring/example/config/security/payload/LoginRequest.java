package br.com.pgioseffi.spring.example.config.security.payload;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

	@NotBlank
	private String username;

	@NotBlank
	private String password;

}