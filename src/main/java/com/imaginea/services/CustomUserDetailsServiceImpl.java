package com.imaginea.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;

import com.imaginea.model.EmployeeDetails;

@Service("CustomUserDetailsService")
public class CustomUserDetailsServiceImpl implements
		AuthenticationUserDetailsService, UserDetailsService {

	@Autowired
	EmployeeDetailsService employeeDetailsServices;
	
	
	public UserDetails loadUserByUsername(String identityURL)
			throws UsernameNotFoundException, DataAccessException {
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
		
		User user = new User(identityURL, "", false, false, false, false, authorities);
		
		return user;
	}

	public UserDetails loadUserDetails(Authentication token)
			throws UsernameNotFoundException {
		System.out.println("in loadUserDetails>>>>>");
		OpenIDAuthenticationToken openidToken = (OpenIDAuthenticationToken)token;
		String identifier = openidToken.getIdentityUrl();
		String email = "";
		List<OpenIDAttribute> attributes = openidToken.getAttributes();
		List<EmployeeDetails> employeesDetails;
		EmployeeDetails employeeDetails;
		
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
		
		for (OpenIDAttribute attribute : attributes) {
            if (attribute.getName().equals("email")) {
                email = attribute.getValues().get(0);
            }
		}
		
		if(email == ""){
			throw new UsernameNotFoundException("User is not registered with us.");
		}else{
			System.out.println("email>>>>>>" + email);
			employeesDetails = employeeDetailsServices.getEmployeeDetailsForEmail(email);
		}
		
		if(employeesDetails.size() == 1){
			employeeDetails = employeesDetails.get(0);
			System.out.println("employeeDetails>>>>>>" + employeeDetails.getEmail());
			System.out.println("employeeDetails>>>>>>" + employeeDetails.getFirstName());
			System.out.println("employeeDetails>>>>>>" + employeeDetails.getLastName());
			System.out.println("employeeDetails>>>>>>" + employeeDetails.getUserName());
			System.out.println("employeeDetails>>>>>>" + employeeDetails.getId());
		}else{
			throw new UsernameNotFoundException("User is not registered with us.");
		}
		
		User user = new User(identifier, "", false, false, false, false, authorities);
		
		
		
		if(identifier != ""){
			employeeDetails.setUserName(identifier);
			employeeDetailsServices.updateEmployeeDetails(employeeDetails);
		}else{
			throw new UsernameNotFoundException("Unable to fetch Identity url.");
		}
		
		
		
		
		return user;
	}

}
