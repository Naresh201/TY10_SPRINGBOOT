package com.te.springbooot2.services;

import java.util.List;

import com.te.springbooot2.beans.Admin;
import com.te.springbooot2.beans.Product;
import com.te.springbooot2.beans.ProductResponse;

public interface ProductServices {
	
	public boolean addProduct(Product product);
	public List<Product> getAllEmployees();
	public Product getProduct(int productid);
	public Admin authenticate(Admin admin);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int productid);


}
