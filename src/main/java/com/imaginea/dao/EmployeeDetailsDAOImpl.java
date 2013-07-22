package com.imaginea.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.model.EmployeeDetails;

@Repository
public class EmployeeDetailsDAOImpl implements EmployeeDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Integer createEmployeeDetail(EmployeeDetails employee) {
		return (Integer)sessionFactory.getCurrentSession().save(employee);
	}

	@Transactional
	public void updateEmployeeDetail(EmployeeDetails employee) {		
		sessionFactory.getCurrentSession().update(employee);
	}

	@Transactional
	public void deleteEmployeeDetail(EmployeeDetails employee) {
		sessionFactory.getCurrentSession().delete(employee);
	}

	@Transactional
	public EmployeeDetails getEmployeeDetail(Integer id) {
		return (EmployeeDetails) sessionFactory.getCurrentSession().get(EmployeeDetails.class, id);
	}

	@Transactional
	public List<EmployeeDetails> getEmployeeDetail(String parameter, String value) {
		List<EmployeeDetails> empList = sessionFactory.getCurrentSession().createQuery("from EmployeeDetails ed where ed." + parameter + " = '" +value+ "'").list();
		System.out.println("empList.size(): " + empList.size());
		return empList;
	}

	@Transactional
	public List<EmployeeDetails> getEmployeeDetail() {
		return sessionFactory.getCurrentSession().createQuery("from EmployeeDetails").list();
	}

}
