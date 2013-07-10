package com.imaginea.dao;

import com.imaginea.model.LeaveApplication;

public interface LeaveApplicationDAO {
	public void addLeave(LeaveApplication leave);

	public void setLeaveStatus(Integer id, String status);
}
