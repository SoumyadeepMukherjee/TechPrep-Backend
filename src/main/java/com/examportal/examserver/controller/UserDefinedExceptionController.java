package com.examportal.examserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examportal.examserver.exception.CategoryNotFoundException;
import com.examportal.examserver.exception.QuestionNotFoundException;
import com.examportal.examserver.exception.QuizNotFoundException;

@ControllerAdvice
public class UserDefinedExceptionController {

	@ExceptionHandler(value=CategoryNotFoundException.class)
	public ResponseEntity<Object> exception(CategoryNotFoundException exception)
	{
		return new ResponseEntity<>("Category Not Found!",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=QuizNotFoundException.class)
	public ResponseEntity<Object> exception(QuizNotFoundException exception)
	{
		return new ResponseEntity<>("Quiz Not Found!",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=QuestionNotFoundException.class)
	public ResponseEntity<Object> exception(QuestionNotFoundException exception)
	{
		return new ResponseEntity<>("Question Not Found!",HttpStatus.NOT_FOUND);
	}
}
