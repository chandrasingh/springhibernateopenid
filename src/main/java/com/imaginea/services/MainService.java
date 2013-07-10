package com.imaginea.services;

import com.imaginea.model.EmployeeDetails;
import com.imaginea.model.LeaveApplication;

public interface MainService {
	public EmployeeDetails getEmployeeDetailsForUserName(String userName);
	
	public void addLeave(LeaveApplication leave);
	
	public void setLeaveStatus(Integer id, String status);
	
	public LeaveApplication getLeavesForManagerID(Integer managerID);
}
