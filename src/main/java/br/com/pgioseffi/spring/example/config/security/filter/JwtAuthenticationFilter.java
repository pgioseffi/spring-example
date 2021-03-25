package br.com.pgioseffi.spring.example.config.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.pgioseffi.spring.example.config.security.jwt.JwtTokenProvider;
import br.com.pgioseffi.spring.example.constantes.Constantes;
import br.com.pgioseffi.spring.example.service.UserDetailsApplicationService;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private UserDetailsApplicationService userDetailsApplicationService;

	private static final Logger LOG = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain) throws ServletException, IOException {
		try {
			final var bearerToken = request.getHeader(Constantes.TOKEN_HEADER);
			final var jwt = StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ") ? bearerToken.substring(7) : null;

			if (StringUtils.hasText(jwt) && this.tokenProvider.validateToken(jwt)) {
				final var userDetails = this.userDetailsApplicationService.loadUserById(this.tokenProvider.getUserIdFromJWT(jwt));
				final var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (final Exception e) {
			JwtAuthenticationFilter.LOG.error(String.format("Não foi possível autenticar o usuário no contexto de segurança. ERRO: %s.", e.getMessage()), e);
		}

		filterChain.doFilter(request, response);
	}
}