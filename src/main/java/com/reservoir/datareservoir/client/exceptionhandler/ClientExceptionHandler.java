package com.reservoir.datareservoir.client.exceptionhandler;

import java.net.ConnectException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClientExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ConnectException.class)
	public ModelAndView handleConnectException(ConnectException e) {
		return new ModelAndView("/error/connect");
	}

}
