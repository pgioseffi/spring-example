package br.com.pgioseffi.spring.example.dto;

import java.util.List;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "novoUser")
public class UserDTO extends BaseDTO {

	private String name;
	private String username;

	@Email
	private String email;
	private String password;
	private List<RoleDTO> roles;
	private UserTokenDTO token;

}