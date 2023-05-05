package com.examportal.examserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examportal.examserver.exception.QuestionNotFoundException;

@ControllerAdvice
public class QuestionExceptionController {

	@ExceptionHandler(value=QuestionNotFoundException.class)
	public ResponseEntity<Object> exception(QuestionNotFoundException exception)
	{
		return new ResponseEntity<>("Question Not Found!",HttpStatus.NOT_FOUND);
	}
}
