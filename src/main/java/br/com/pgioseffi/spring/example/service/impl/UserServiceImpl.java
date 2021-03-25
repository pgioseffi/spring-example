package br.com.pgioseffi.spring.example.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pgioseffi.spring.example.exception.UserNotFoundException;
import br.com.pgioseffi.spring.example.model.User;
import br.com.pgioseffi.spring.example.repository.UserRepository;
import br.com.pgioseffi.spring.example.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository repository;

	@Override
	public Optional<User> loadUserByUsername(final String username) {
		return this.repository.findByUsername(username);
	}

	@Override
	public User loadUserByUsernameObrigatoriamente(final String username) {
		return this.loadUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with username: %s.", username)));
	}

	@Override
	public Optional<User> loadUserById(final UUID id) {
		return this.repository.findById(id);
	}

	@Override
	public User loadUserByIdObrigatoriamente(final UUID id) {
		return this.loadUserById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@Override
	public Optional<User> loadUserById(final String id) {
		return this.loadUserById(UUID.fromString(id));
	}

	@Override
	public User loadUserByIdObrigatoriamente(final String id) {
		return this.loadUserByIdObrigatoriamente(UUID.fromString(id));
	}
}