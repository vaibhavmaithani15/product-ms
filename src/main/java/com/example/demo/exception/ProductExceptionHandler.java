package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.ui.ErrorResponseModel;

@RestControllerAdvice
public class ProductExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleUserNotFoundException(ProductNotFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseModel.builder().errorMessage(e.getMessage()).errorReportingTime(System.currentTimeMillis()).errorCode(HttpStatus.NOT_FOUND.value()).build());
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleUserNotFoundException(Exception e)
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponseModel.builder().errorMessage(e.getMessage()).errorReportingTime(System.currentTimeMillis()).errorCode(HttpStatus.NOT_FOUND.value()).build());
	}
}
