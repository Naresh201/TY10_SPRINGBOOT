package com.te.springbooot2.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springbooot2.beans.ProductResponse;
import com.te.springbooot2.exception.ProductException;

@RestControllerAdvice
public class ProductControllerAdvice  {
	
	@ExceptionHandler(ProductException.class)
	public ProductResponse  handleEmployeeExp(ProductException exception) {
		ProductResponse  response = new ProductResponse ();
		response.setStatus(404);
		response.setMsg(exception.getMessage());
		return response;
	}
}
