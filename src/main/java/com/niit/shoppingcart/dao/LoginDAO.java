package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Login;

public interface LoginDAO {
	
	Login get(int lid);
	List<Login> list();
	boolean save(Login login);
	boolean delete(int lid);

}
