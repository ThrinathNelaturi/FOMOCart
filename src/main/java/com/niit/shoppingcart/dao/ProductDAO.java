package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Product;

@Repository
public interface ProductDAO {
	
	public boolean saveOrUpdate(Product product);
	
	public boolean delete(Product product);
	public Product get(int id);//public
	public List<Product> list();//public
	public List<Product> getproduct(int id);
	
	
	}

