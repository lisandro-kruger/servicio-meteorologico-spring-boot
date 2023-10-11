package com.api.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("Status Cod", status.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		responseBody.put("Mensaje:", errors);

		return new ResponseEntity<>(responseBody, headers, status);
	}

	@ExceptionHandler(BussinessException.class)
	public ResponseEntity<Object> handleBussinessException(BussinessException ex, WebRequest request) {
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("Status Cod", HttpStatus.CONFLICT);
		responseBody.put("Mensaje:", ex.getMessage());

		return new ResponseEntity<>(responseBody, HttpStatus.CONFLICT);
	}

}
