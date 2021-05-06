package com.te.springbooot2.dao;

import java.util.List;

import com.te.springbooot2.beans.Admin;
import com.te.springbooot2.beans.Product;

public interface ProductDao {

	public List<Product> getAllEmployees();
	public Product getEmployee(int productid);
	public Admin authenticate(Admin admin);
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int productid);
}
