package com.mkthakral.tech.challange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
public class MyController {
	
	Logger logger = LoggerFactory.getLogger(MyController.class);

	@GetMapping(path = "/api")
	public String acceptId(@RequestParam int id) {
		logger.info(Integer.toString(id));
		return "ok";
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex) {
		return "failed";
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public String handleParamTypeMismatch(MethodArgumentTypeMismatchException ex) {
		return "failed";
	}
	
	

}
