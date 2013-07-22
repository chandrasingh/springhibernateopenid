package com.imaginea.dao;

import java.util.List;

import com.imaginea.model.EmployeeDetails;

public interface EmployeeDetailsDAO {
	public Integer createEmployeeDetail(EmployeeDetails employee);
	public EmployeeDetails getEmployeeDetail(Integer id);
	public List<EmployeeDetails> getEmployeeDetail(String parameter, String value);
	public List<EmployeeDetails> getEmployeeDetail();
	public void updateEmployeeDetail(EmployeeDetails employee);
	public void deleteEmployeeDetail(EmployeeDetails employee);
}
