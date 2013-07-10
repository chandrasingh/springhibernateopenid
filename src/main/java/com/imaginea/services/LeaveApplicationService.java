package com.imaginea.services;

import com.imaginea.model.LeaveApplication;

public interface LeaveApplicationService {
	public void addLeave(LeaveApplication leave);

	public void setLeaveStatus(Integer id, String status);
}
