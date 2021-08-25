package com.example.gateways.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;


@ControllerAdvice
@Component
public class GlobalExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
		return new ResponseEntity<String>( ex.getMessage(), HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> handleValidationException(ValidationException exception) {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
}
