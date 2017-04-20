package com.redhat.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.redhat.exception.GenericException;
import com.redhat.exception.IdNotMatchException;

@RestControllerAdvice
public class SampleExceptionHandler {

	@ExceptionHandler(IdNotMatchException.class)
	public ResponseEntity<? extends GenericException> exception(IdNotMatchException exception){
		GenericException genericException = new GenericException(exception.getErrorCode(), exception.getErrorMsg());
		return new ResponseEntity<GenericException>(genericException,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<? extends GenericException> genericException(Exception exception){
		GenericException genericException = new GenericException("ERR_500", exception.getMessage());
		return new ResponseEntity<GenericException>(genericException,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
