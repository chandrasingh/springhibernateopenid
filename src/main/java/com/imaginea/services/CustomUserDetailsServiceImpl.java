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
	private EmployeeService employeeService;

	@SuppressWarnings("deprecation")
	public UserDetails loadUserByUsername(String identityURL)
			throws UsernameNotFoundException, DataAccessException {
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthorityImpl("ROLE_USER"));

		User user = new User(identityURL, "", false, false, false, false,
				authorities);

		return user;
	}

	@SuppressWarnings("deprecation")
	public UserDetails loadUserDetails(Authentication token)
			throws UsernameNotFoundException {
		OpenIDAuthenticationToken openidToken = (OpenIDAuthenticationToken) token;
		String identifier = openidToken.getIdentityUrl();
		String email = "";
		List<OpenIDAttribute> attributes = openidToken.getAttributes();

		EmployeeDetails employee;
		List<EmployeeDetails> employeeList;

		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthorityImpl("ROLE_USER"));

		User user = new User(identifier, "", false, false, false, false,
				authorities);

		for (OpenIDAttribute attribute : attributes) {
			if (attribute.getName().equals("email")) {
				email = attribute.getValues().get(0);
			}
		}

		if (email.equals("")) {
			throw new UsernameNotFoundException("Unable to retrieve email id.");
		}

		employeeList = employeeService.getEmployeeDetail("email", email);

		if (employeeList.size() == 0) {
			throw new UsernameNotFoundException("User is not registered with us.");
		}

		employee = employeeList.get(0);

		employee.setUserName(identifier);

		employeeService.updateEmployeeDetail(employee);

		return user;
	}

}
