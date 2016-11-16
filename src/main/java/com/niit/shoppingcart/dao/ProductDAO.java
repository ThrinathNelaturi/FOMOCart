package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.model.Product;

public interface ProductDAO {
	
    Product get(int id);//public
    List<Product> list();//public
    boolean save(Product product);
	boolean delete(int id);
	
	}

