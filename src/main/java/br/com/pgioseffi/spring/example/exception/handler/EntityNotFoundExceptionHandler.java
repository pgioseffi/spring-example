package br.com.pgioseffi.spring.example.exception.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.pgioseffi.spring.example.exception.PreVendaNotFoundException;
import br.com.pgioseffi.spring.example.exception.RegistroVendaNotFoundException;
import br.com.pgioseffi.spring.example.exception.UserNotFoundException;

@ControllerAdvice
public class EntityNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ PreVendaNotFoundException.class, RegistroVendaNotFoundException.class, UserNotFoundException.class, UsernameNotFoundException.class })
	public static void handleEntityNotFound(final HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
}