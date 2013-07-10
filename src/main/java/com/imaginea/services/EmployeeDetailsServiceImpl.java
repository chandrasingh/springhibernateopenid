package com.imaginea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.dao.EmployeeDetailsDAO;
import com.imaginea.model.EmployeeDetails;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService{
	@Autowired
	private EmployeeDetailsDAO employeeDetailsDAO;
	
	@Transactional
	public List<EmployeeDetails> getEmployeeDetailsForUserName(String userName){
		return employeeDetailsDAO.getEmployeeDetailForUserName(userName);
	}
	
	@Transactional
	public List<EmployeeDetails> getEmployeeDetailsForEmail(String email){
		System.out.println("in getEmployeeDetailsForEmail ");
		System.out.println("email>>>>>>>>>>>" + email);
		return employeeDetailsDAO.getEmployeeDetailForEmail(email);
	}
	
	@Transactional
	public void updateEmployeeDetails(EmployeeDetails employeeDetails){
		System.out.println("in updateEmployeeDetails");
		
		employeeDetailsDAO.updateEmployeeDetails(employeeDetails);
		System.out.println("in updateEmployeeDetails called employeeDetailsDAO.updateEmployeeDetails(employeeDetails);");
	}
}
