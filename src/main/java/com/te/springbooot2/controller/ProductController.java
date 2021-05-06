package com.te.springbooot2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbooot2.beans.Admin;
import com.te.springbooot2.beans.Product;
import com.te.springbooot2.beans.ProductResponse;
import com.te.springbooot2.services.ProductServices;

@RestController
public class ProductController {
	@Autowired
	ProductServices services;
	
	@GetMapping(path="/getall" , produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse getAllEmployees() {
		ProductResponse response = new ProductResponse();
	List<Product> beans = 	 services.getAllEmployees();
	if(beans !=null) {
		response.setStatus(200);
		response.setMsg("sucessfully retrived the data");
		response.setProducts(beans);
	}else {
		response.setStatus(404);
		response.setMsg("failure due to techinal problem");
	}
		return response;
	}
	
	@PostMapping(path="/getproduct" , produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse getAllEmployee(int id) {
		ProductResponse response = new ProductResponse();
	 Product beans = 	 services.getProduct(id);
	if(beans !=null) {
		response.setStatus(200);
		response.setMsg("sucessfully retrived the data");
		response.setProduct(beans);
	}else {
		response.setStatus(404);
		response.setMsg("record not found ");
	}
		return response;
	}
	
	@PostMapping(path="/getproduct" , produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE},
			consumes={MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse addEmployee(@RequestBody Product product) {
		ProductResponse response = new ProductResponse();
	 	
	if( services.addProduct(product)) {
		response.setStatus(200);
		response.setMsg("sucessfully added the data");
	}else {
		response.setStatus(404);
		response.setMsg(" data is not added ");
	}
		return response;
	}
	
	@PostMapping(path="/getproduct" , produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse addDelete(int productid) {
		ProductResponse response = new ProductResponse();
	 	
	if( services.deleteProduct(productid)) {
		response.setStatus(200);
		response.setMsg("sucessfully deleted");
	}else {
		response.setStatus(404);
		response.setMsg(" data is not found ");
	}
		return response;
	}
	@PostMapping(path="/getproduct" , produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE},
			consumes={MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse updateEmployee(@RequestBody Product product) {
		ProductResponse response = new ProductResponse();
	 	
	if( services.updateProduct(product)) {
		response.setStatus(200);
		response.setMsg("sucessfully updated the data");
	}else {
		response.setStatus(404);
		response.setMsg(" data is not updated ");
	}
		return response;
	}
	
	@PostMapping(path = "/adminLogin", produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse authenticateAdmin(@RequestBody Admin admin,HttpServletRequest request) {
		Admin bean = services.authenticate(admin);
		
		ProductResponse response = new ProductResponse();
		if (bean != null) {
			System.out.println(" success login");
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedInfo", bean);
		session.setMaxInactiveInterval(60);
			response.setStatus(200);
		    response.setMsg("sucessfully admin logged in ");
		
		} else {
			response.setStatus(404);
		    response.setMsg("credentials are incorrect ");
		}
		return response;
	}
	
	
}
