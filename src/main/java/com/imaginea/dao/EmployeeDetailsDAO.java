package com.imaginea.dao;

import java.util.List;

import com.imaginea.model.EmployeeDetails;

public interface EmployeeDetailsDAO {
	public List<EmployeeDetails> getEmployeeDetailForEmail(String email);
	public List<EmployeeDetails> getEmployeeDetailForUserName(String userName);
	public void updateEmployeeDetails(EmployeeDetails employeeDetails);
}
