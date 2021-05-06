package com.te.springbooot2.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("response")
@XmlRootElement(name="response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse implements Serializable {
	
	    @JsonProperty("status")
	    @XmlElement(name="status-code")
		private int status;
	    
		private String msg;
		@JsonProperty("product_info")
	    @XmlElement(name="product-info")
		private Product product;
		private List<Product> products;
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public List<Product> getProducts() {
			return products;
		}
		public void setProducts(List<Product> products) {
			this.products = products;
		}
}
