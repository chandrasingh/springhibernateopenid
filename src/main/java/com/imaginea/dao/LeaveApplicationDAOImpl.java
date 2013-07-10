package com.imaginea.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imaginea.model.LeaveApplication;

@Repository
public class LeaveApplicationDAOImpl implements LeaveApplicationDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addLeave(LeaveApplication leave) {
		sessionFactory.getCurrentSession().save(leave);
	}

	public void setLeaveStatus(Integer id, String status) {
		LeaveApplication leave = (LeaveApplication) sessionFactory.getCurrentSession().load(LeaveApplication.class, id);
		
		if (null != leave) {
			leave.setStatus(status);
            sessionFactory.getCurrentSession().save(leave);
        }
	}

}
