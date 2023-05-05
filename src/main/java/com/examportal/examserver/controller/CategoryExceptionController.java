package com.examportal.examserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examportal.examserver.exception.CategoryNotFoundException;

@ControllerAdvice
public class CategoryExceptionController {

	@ExceptionHandler(value=CategoryNotFoundException.class)
	public ResponseEntity<Object> exception(CategoryNotFoundException exception)
	{
		return new ResponseEntity<>("Category Not Found!",HttpStatus.NOT_FOUND);
	}
}
