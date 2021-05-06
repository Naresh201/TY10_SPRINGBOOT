package com.te.springbooot2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbooot2.beans.Admin;
import com.te.springbooot2.beans.Product;
import com.te.springbooot2.dao.ProductDao;

@Service
public abstract class ProductServiceImp implements ProductServices {

	@Autowired
	ProductDao dao;
	
	@Override
	public List<Product> getAllEmployees() {
		return dao.getAllEmployees();
	}
	@Override
	public Product getProduct(int productid) {
		return dao.getEmployee(productid);
	}
	@Override
	public Admin authenticate(Admin admin) {
		return dao.authenticate(admin);
	}
	@Override
	public boolean addProduct(Product product) {
		return dao.addProduct(product);
	}
	@Override
	public boolean updateProduct(Product product){
		return dao.updateProduct(product);
	}
	@Override
	public boolean deleteProduct(int productid) {
		return dao.deleteProduct(productid);
	}

}
