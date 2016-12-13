package com.niit.shoppingcart.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingcart.dao.*;
import com.niit.shoppingcart.model.*;

@SuppressWarnings("deprecation") 

public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
    public ProductDAOImpl(SessionFactory  sessionFactory)
  {
    this.sessionFactory=sessionFactory;
  }

 
  	
    @Transactional
	public boolean update(Product product){
		try {
		sessionFactory.getCurrentSession().update(product);
		return true;
		} catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		
	}
    @Transactional
    public boolean delete(Product product) {
    	try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
			} catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}
    
    
    @Transactional
	public Product get(int id) {
		String hql = "From Product where id=" + id;
		
		
		
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings({ "unchecked" })
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		
		return null;
	}
		


	
	@Transactional
	public List<Product> list() {
		@SuppressWarnings({ "unchecked" })
		List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession()
				.createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listProduct;
	}

	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> getproduct(int id) {
		String hql="from Product where id= "+id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listProduct = (List<Product>) query.list();
		return listProduct;
	}
	 //save -save the record - if the record exist it will throw error
  	//update - update the record - if the record does not exist, it will throw error
  	//save or update - if the record exist, it will update
  	//                 - if the record does not exist it will create
	
	
	@Transactional
	public boolean saveOrUpdate(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	
}