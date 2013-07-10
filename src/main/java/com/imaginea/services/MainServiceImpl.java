package com.imaginea.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.model.EmployeeDetails;
import com.imaginea.model.LeaveApplication;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private LeaveApplicationService leaveApplicationService;
	
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	
	@Transactional
	public EmployeeDetails getEmployeeDetailsForUserName(String userName) {
		return employeeDetailsService.getEmployeeDetailsForUserName(userName).get(0);
	}

	@Transactional
	public void addLeave(LeaveApplication leave) {
		leaveApplicationService.addLeave(leave);
	}

	@Transactional
	public void setLeaveStatus(Integer id, String status) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public LeaveApplication getLeavesForManagerID(Integer managerID) {
		// TODO Auto-generated method stub
		return null;
	}

}
