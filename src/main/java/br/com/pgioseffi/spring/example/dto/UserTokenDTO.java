package br.com.pgioseffi.spring.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTokenDTO {

	private String accessToken;

	@Builder.Default
	private String tokenType = "Bearer";

}