package br.com.pgioseffi.spring.example.config.security.controller;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pgioseffi.spring.example.config.security.jwt.JwtTokenProvider;
import br.com.pgioseffi.spring.example.config.security.model.UserPrincipal;
import br.com.pgioseffi.spring.example.config.security.payload.LoginRequest;
import br.com.pgioseffi.spring.example.config.security.payload.TokenResponse;
import br.com.pgioseffi.spring.example.constantes.Constantes;
import br.com.pgioseffi.spring.example.dto.RoleDTO;
import br.com.pgioseffi.spring.example.dto.UserDTO;
import br.com.pgioseffi.spring.example.dto.UserTokenDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthRestController {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider tokenProvider;

	@PostMapping("/v1/auth/")
	public ResponseEntity<UserDTO> authenticateUser(@Valid @RequestBody final LoginRequest loginRequest) {
		final var authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		final var userPrincipal = (UserPrincipal) authentication.getPrincipal();
		final var jwt = this.tokenProvider.generateToken(authentication);

		final UserDTO currentUser = UserDTO.novoUser().id(userPrincipal.getId()).name(userPrincipal.getName()).username(userPrincipal.getUsername()).email(userPrincipal.getEmail())
				.token(new UserTokenDTO(jwt, Constantes.BEARER_PREFIX))
				.roles(userPrincipal.getAuthorities().stream().map(authority -> RoleDTO.novaRole().name(authority.getAuthority()).build()).collect(Collectors.toList())).build();

		return ResponseEntity.ok(currentUser);
	}

	@GetMapping("/refresh")
	public ResponseEntity<TokenResponse> gerarRefreshTokenJwt(final HttpServletRequest request) {
		Optional<String> currentToken = Optional.ofNullable(request.getHeader(Constantes.TOKEN_HEADER));

		if (currentToken.isPresent() && currentToken.get().startsWith(Constantes.BEARER_PREFIX)) {
			currentToken = Optional.of(currentToken.get().substring(7));
		}

		if (!currentToken.isPresent()) {
			throw new RuntimeException("Token não informado.");
		} else if (!this.tokenProvider.validateToken(currentToken.get())) {
			throw new RuntimeException("Token inválido ou expirado.");
		}

//		if (!t_rtkCurrent.getErrors().isEmpty()) {
//			return ResponseEntity.badRequest().body(t_rtkCurrent);
//		}

		return ResponseEntity.ok(new TokenResponse(this.tokenProvider.refreshToken(currentToken.get())));
	}
}