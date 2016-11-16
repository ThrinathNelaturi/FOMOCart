package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.model.Category;

public interface CategoryDAO 
{
	Category get(int cid);
	List<Category> list();
	boolean save(Category category);
	boolean delete(int cid);
	
	
}
