package br.com.pgioseffi.spring.example.service;

import java.util.Optional;
import java.util.UUID;

import br.com.pgioseffi.spring.example.model.User;

public interface UserService {

	Optional<User> loadUserByUsername(String username);

	User loadUserByUsernameObrigatoriamente(String username);

	Optional<User> loadUserById(UUID id);

	Optional<User> loadUserById(String id);

	User loadUserByIdObrigatoriamente(UUID id);

	User loadUserByIdObrigatoriamente(String id);

}