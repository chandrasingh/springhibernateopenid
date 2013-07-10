package com.imaginea.services;

import java.util.List;

import com.imaginea.model.EmployeeDetails;

public interface EmployeeDetailsService {
	public List<EmployeeDetails> getEmployeeDetailsForUserName(String userName);
	public List<EmployeeDetails> getEmployeeDetailsForEmail(String email);
	public void updateEmployeeDetails(EmployeeDetails employeeDetails);
}
