package com.bway.springproject.dao;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bway.springproject.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void signup(User u) {
		Session sess=sessionFactory.getCurrentSession();
		sess.save(u);
	}

	@Override
	@Transactional
	public User sigup(String username, String password) {
		Session sess=sessionFactory.getCurrentSession();
		Criteria crt=sess.createCriteria(User.class);
		crt.add(Restrictions.eq("username", username)).add(Restrictions.eq("password", password));
		User u=(User) crt.uniqueResult();
		return u;
	}
}
