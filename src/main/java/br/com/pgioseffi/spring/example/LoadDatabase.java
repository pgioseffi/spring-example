package br.com.pgioseffi.spring.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.pgioseffi.spring.example.model.PreVenda;
import br.com.pgioseffi.spring.example.service.PreVendaService;

@Configuration
public class LoadDatabase {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	public CommandLineRunner initDatabase(final PreVendaService service) {
		return args -> {
			final var agora = LocalDateTime.now();
			LoadDatabase.LOGGER.info("Carregando " + service.novaPreVenda(PreVenda.novaPreVenda().codigoAparelho(7892597349998L).codigoLoja(1302L).cpf("04155519194").dataVenda(agora)
					.descontoTriangulacao(new BigDecimal("1.1")).id(UUID.randomUUID()).status(1).build()));
			LoadDatabase.LOGGER.info("Carregando " + service.novaPreVenda(PreVenda.novaPreVenda().codigoAparelho(7892597349999L).codigoLoja(1302L).cpf("04155519194").dataVenda(agora)
					.descontoTriangulacao(new BigDecimal("1.2")).id(UUID.randomUUID()).status(1).build()));
		};
	}
}