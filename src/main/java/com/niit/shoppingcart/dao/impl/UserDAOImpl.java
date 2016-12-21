/*package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;


	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("deprecation")
	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}
@SuppressWarnings("deprecation")
@Transactional
	public User get(int id) {
		String hql = "from"+" User"+" where userId="+id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}
@Transactional
	public void delete(int id) {
		User UserToDelete = new User();
		UserToDelete.setUserId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
	}

@Transactional
	public boolean isValidUser(String userName, String password) {
		@SuppressWarnings("deprecation")
		Criteria c=sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("userName",userName));
		c.add(Restrictions.eq("password",password));
		
		@SuppressWarnings("rawtypes")
		List list = c.list();
		if(list==null || list.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@SuppressWarnings("deprecation")
	@Transactional
	public User get(String userName) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("userName",userName));
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) c.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		else {
			return null;
		}
	}
	pradeeeppp
}*/