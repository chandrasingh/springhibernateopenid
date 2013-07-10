package com.imaginea.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imaginea.model.EmployeeDetails;

@Repository
public class EmployeeDetailsDAOImpl implements EmployeeDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<EmployeeDetails> getEmployeeDetailForUserName(String userName) {
		List employees = sessionFactory.getCurrentSession().createQuery("FROM EmployeeDetails ed WHERE ed.userName = '" + userName + "'").list();
		return employees;
	}
	
	public List<EmployeeDetails> getEmployeeDetailForEmail(String email) {
		System.out.println("in getEmployeeDetailForEmail ");
		System.out.println("email>>>>>>>>>>>" + email);
		List employees = sessionFactory.getCurrentSession().createQuery("FROM EmployeeDetails ed WHERE ed.email = '" + email + "'").list();
		return employees;
	}
	

	public void updateEmployeeDetails(EmployeeDetails employeeDetails){
		sessionFactory.getCurrentSession().update(employeeDetails);
	}
}
