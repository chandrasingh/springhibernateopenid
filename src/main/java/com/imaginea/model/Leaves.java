package com.imaginea.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="leaves")
public class Leaves {
	private Integer id;
    
    private String from;
    
    private String to;
    
    private String status;
    
    private String reason;
    
    private EmployeeDetails employee;
    
    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId(){
		return id;
	}

	public void setId(Integer value){
		id = value;
	}

	@Column(name="from", unique = false, nullable = false, length = 15)
   	public String getFrom(){
		return from;
	}

	public void setFrom(String value){
		from = value;
	}

	@Column(name="to", unique = false, nullable = false, length = 15)
   	public String getTo(){
		return to;
	}

	public void setTo(String value){
		to = value;
	}

	@Column(name="status", unique = false, nullable = false)
   	public String getStatus(){
		return status;
	}

	public void setStatus(String value){
		status = value;
	}
	
	@Column(name="reason", unique = false, nullable = false)
   	public String getReason(){
		return reason;
	}

	public void setReason(String value){
		status = reason;
	}
	
	@ManyToOne
   	public EmployeeDetails getEmployee(){
		return employee;
	}

	public void setEmployee(EmployeeDetails value){
		employee = value;
	}
}
