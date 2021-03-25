package br.com.pgioseffi.spring.example.service.impl;

import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.pgioseffi.spring.example.config.security.model.UserPrincipal;
import br.com.pgioseffi.spring.example.service.UserDetailsApplicationService;
import br.com.pgioseffi.spring.example.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsApplicationService {

	private final UserService userService;

	@Override
	public UserDetails loadUserByUsername(final String username) {
		return UserPrincipal.create(this.userService.loadUserByUsernameObrigatoriamente(username));
	}

	@Override
	public UserDetails loadUserById(final UUID id) {
		return UserPrincipal.create(this.userService.loadUserByIdObrigatoriamente(id));
	}
}