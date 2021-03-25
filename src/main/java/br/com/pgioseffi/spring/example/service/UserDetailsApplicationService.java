package br.com.pgioseffi.spring.example.service;

import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailsApplicationService extends UserDetailsService {

	UserDetails loadUserById(UUID id);

}