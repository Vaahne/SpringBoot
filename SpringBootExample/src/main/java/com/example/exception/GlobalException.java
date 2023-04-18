package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
		@ExceptionHandler(EmployeeNotFoundException.class)
		public ResponseEntity<ErrorDetails> handleException(EmployeeNotFoundException ex,WebRequest req){
			
			ErrorDetails errDetails=new ErrorDetails(new Date(),ex.getMessage(),req.getDescription(false));
			return new ResponseEntity<>(errDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
