package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.servicies.ResourceNotFoundException.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //vai interceptar as exceções  que acontecerem para que objeto executar um possovel tratamento 
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)     //pra ele seja capaz de interceptar a requisição que de exeção pra ele cair aqui
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request)	{
		String error = "Resouce not found";//MENSAGEM BASICA DE ERRO
		HttpStatus status = HttpStatus.NOT_FOUND;//status de um erro
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(DatabaseException.class)     //pra ele seja capaz de interceptar a requisição que de exeção pra ele cair aqui
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request)	{
		String error = "database error";//MENSAGEM BASICA DE ERRO
		HttpStatus status = HttpStatus.BAD_REQUEST;//status de um erro
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}//tratamento personalizado 
