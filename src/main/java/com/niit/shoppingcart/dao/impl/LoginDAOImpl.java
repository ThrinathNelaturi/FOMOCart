package com.niit.shoppingcart.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingcart.dao.LoginDAO;
import com.niit.shoppingcart.model.Login;

public class LoginDAOImpl implements LoginDAO
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public LoginDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	@Transactional
	public Login get(int lid) {
       String hql="From Login where lid=" +lid;
		
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Login> listLogin = (List<Login>) query.list();
		
		if (listLogin != null && !listLogin.isEmpty()) {
			return listLogin.get(0);
		}
		return null;
	}

	@Transactional
	public List<Login> list() {
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Login> listLogin = (List<Login>) sessionFactory.getCurrentSession()
				.createCriteria(Login.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listLogin;
	}

	@Transactional
	public boolean save(Login login) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(login);
			return true;
			
		}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(int lid) {
		Login LoginToDelete = new Login();
		LoginToDelete.setLid(lid);
		 sessionFactory.getCurrentSession().delete(LoginToDelete);
		 return true;
	}

	
	
}
