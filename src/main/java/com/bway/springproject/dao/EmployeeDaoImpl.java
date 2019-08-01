package com.bway.springproject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bway.springproject.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee emp) {
		Session sess = sessionFactory.getCurrentSession();
		sess.save(emp);

	}

	@Override
	public void deleteEmployee(int id) {

		Session sess = sessionFactory.getCurrentSession();
		Employee e = (Employee) sess.get(Employee.class, id);
		sess.delete(e);
	}

	@Override
	public void updateEmployee(Employee emp) {
		Session sess = sessionFactory.getCurrentSession();
		sess.update(emp);

	}

	@Override
	public Employee getById(int id) {
		Session sess = sessionFactory.getCurrentSession();
		Employee emp = (Employee) sess.get(Employee.class, id);
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		Session sess = sessionFactory.getCurrentSession();
		Criteria crt = sess.createCriteria(Employee.class);
		return crt.list();
	}
}
