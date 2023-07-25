package com.Project.InfluentiaSupport.Exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(InvalidCredentialException.class)

    public ResponseEntity<?> handleException(InvalidCredentialException ex, WebRequest request){

         

        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

        logger.error("Invalid Credential Exception occurred!", ex);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }
	
	@ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

         logger.error("Resource Not Found Exception occurred!", ex);

         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }
	
	
}
