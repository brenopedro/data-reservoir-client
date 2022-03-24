package com.reservoir.datareservoir.client.exceptionhandler;

import java.net.ConnectException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClientExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<String> handleConnectException(ConnectException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}
