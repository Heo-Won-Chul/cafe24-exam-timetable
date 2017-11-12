package com.cafe24.timetable.common;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({MissingServletRequestParameterException.class})
	public ResponseEntity<?> createMissingParamException() {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@ExceptionHandler({DataAccessException.class, SQLException.class})
	public ResponseEntity<?> createDatabaseException() {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
