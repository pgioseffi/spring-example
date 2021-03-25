package br.com.pgioseffi.spring.example.config.security;

import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.pgioseffi.spring.example.config.security.model.UserPrincipal;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

	@Bean
	public AuditorAware<UUID> auditorProvider() {
		return new SpringSecurityAuditAwareImpl();
	}
}

class SpringSecurityAuditAwareImpl implements AuditorAware<UUID> {

	@Override
	public Optional<UUID> getCurrentAuditor() {
		final var authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken ? Optional.empty()
				: Optional.ofNullable(((UserPrincipal) authentication.getPrincipal()).getId());
	}
}