package com.imaginea.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.dao.LeaveApplicationDAO;
import com.imaginea.model.LeaveApplication;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService {

	@Autowired
	private LeaveApplicationDAO leaveApplicationDAO;
	
	@Transactional
	public void addLeave(LeaveApplication leave) {
		leaveApplicationDAO.addLeave(leave);

	}

	@Transactional
	public void setLeaveStatus(Integer id, String status) {
		leaveApplicationDAO.setLeaveStatus(id, status);
	}

}
