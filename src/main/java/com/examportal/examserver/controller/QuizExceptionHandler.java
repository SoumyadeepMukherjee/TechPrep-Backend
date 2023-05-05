package com.examportal.examserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examportal.examserver.exception.QuizNotFoundException;

@ControllerAdvice
public class QuizExceptionHandler {
	
	@ExceptionHandler(value=QuizNotFoundException.class)
	public ResponseEntity<Object> exception(QuizNotFoundException exception)
	{
		return new ResponseEntity<>("Quiz Not Found!",HttpStatus.NOT_FOUND);
	}
}
