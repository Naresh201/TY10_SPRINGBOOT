package com.te.springbooot2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springbooot2.beans.Admin;
import com.te.springbooot2.beans.Product;
import com.te.springbooot2.exception.ProductException;
@Repository
public class ProductDaoImp  implements ProductDao{

	@Override
	public List<Product> getAllEmployees() {
		List<Product> Productbeans = null;
		try {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		      EntityManager manager  = factory.createEntityManager();
			Query query = manager.createQuery("from Product");
			Productbeans = query.getResultList();
		} catch (Exception e) {
			Productbeans = null;
			e.printStackTrace();
		}
		return Productbeans;
	}
	@Override
	public Product getEmployee(int productid) {
		Product Productbeans = null;
		try {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		      EntityManager manager  = factory.createEntityManager();
			Query query = manager.createQuery("from Product where id=:id");
			query.setParameter("id", productid);
	      Productbeans  = (Product) query.getSingleResult();
			
		} catch (Exception e) {
			Productbeans = null;
			e.printStackTrace();
		}
		return Productbeans;
	}
	@Override
	public Admin authenticate(Admin admin) {
		
		Admin Adminbeans = null;
		try {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		      EntityManager manager  = factory.createEntityManager();
			Query query = manager.createQuery("from Admin where id=:id and adminpwd=:pwd");
			int adminid = admin.getAdminid();
			String password = admin.getAdminpwd();
			query.setParameter("id", adminid);
			query.setParameter("pwd", password);
		    Adminbeans = 	(Admin) query.getSingleResult();
		} catch (Exception e) {
			Adminbeans = null;
			e.printStackTrace();
		}
		return Adminbeans;
	}
	@Override
	public boolean addProduct(Product product) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			      EntityManager manager  = factory.createEntityManager();
			      EntityTransaction transaction = manager.getTransaction();
			      transaction.begin();
				manager.persist(product);
				transaction.commit();
			    return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	@Override
	public boolean updateProduct(Product product) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			      EntityManager manager  = factory.createEntityManager();
			      EntityTransaction transaction = manager.getTransaction();
			      transaction.begin();
			      Product product1 = manager.find(Product.class, product.getProductid());
			      if(product.getProductid() !=0) {
			    	  product1.setProductid(product.getProductid());
			      }
			      if(product.getProductname()!=null) {
			    	  product1.setProductname(product.getProductname());
			      }
			      if(product.getProductprice() !=0) {
			    	  product1.setProductprice(product.getProductprice());
			      }
			      if(product.getQuantity() !=0) {
			    	  product1.setQuantity(product.getQuantity());
			      }
				transaction.commit();
			    return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	@Override
	public boolean deleteProduct(int productid) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Product infoBean = manager.find(Product.class, productid);
			manager.remove(infoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {

			e.printStackTrace();

			throw new ProductException("The Data is not present");
		}
	}
}
