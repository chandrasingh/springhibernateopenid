package com.imaginea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees_details")
public class EmployeeDetails {
	
	private Integer id;
	
	private String email;
	
	private Integer managerId;
	
	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId(){
		return id;
	}

	public void setId(Integer value){
		id = value;
	}
	
	@Column(name="manager_id", unique = false, nullable = false)
	public Integer getManagerId(){
		return managerId;
	}

	public void setManagerId(Integer value){
		managerId = value;
	}

	@Column(name="email", unique = true, nullable = false, length = 45)
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String value){
		email = value;
	}
	
	@Column(name="user_name", unique = false, nullable = false, length = 500)
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String value){
		email = userName;
	}
	
	@Column(name="first_name", unique = false, nullable = false, length = 45)
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String value){
		firstName = value;
	}
	
	@Column(name="last_name", unique = false, nullable = false, length = 45)
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String value){
		lastName = value;
	}
}
