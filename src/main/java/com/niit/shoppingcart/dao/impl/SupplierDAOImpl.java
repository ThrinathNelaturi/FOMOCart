package com.niit.shoppingcart.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO{

@Autowired
private SessionFactory sessionFactory;

public SupplierDAOImpl (SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
		
	@Transactional	
	public Supplier get(int sid) {
	String hql = "From Supplier where sid=" + sid;
	@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	List<Supplier> listSupplier = (List<Supplier>) query.list();
	
	if (listSupplier != null && !listSupplier.isEmpty()) {
		return listSupplier.get(0);
	}
	
	return null;
	}


	@Transactional	
	public List<Supplier> list() {
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Supplier> listSupplier = (List<Supplier>) sessionFactory.getCurrentSession()
				.createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listSupplier;
	}
	

	@Transactional	
	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
			
		}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}



		@Transactional	
		public boolean delete(int sid) {
		Supplier SupplierToDelete = new Supplier();
		SupplierToDelete.setSid(sid);
		 sessionFactory.getCurrentSession().delete(SupplierToDelete);
		 return true;
	}

	
}
