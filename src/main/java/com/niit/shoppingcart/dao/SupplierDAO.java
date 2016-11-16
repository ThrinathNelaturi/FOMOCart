package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {
	
	Supplier get(int sid);
	List <Supplier> list();
	boolean save (Supplier supplier);
	boolean delete(int sid);

}
