package com.capgemini.main.drinkanddelight.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ProductExceptionHandler {
	
	@ExceptionHandler(value= {ProductNotFoundException.class})
	
	public ResponseEntity<Object> exp (ProductNotFoundException e){
		HttpStatus badrequest=HttpStatus.BAD_REQUEST;
		ProductException productException=new ProductException(
	e.getMessage(),
	badrequest,
	ZonedDateTime.now(ZoneId.of("Z"))
	);
		return new ResponseEntity<>(productException,badrequest);
	}
}
