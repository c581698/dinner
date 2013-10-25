package com.dh.core.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dh.core.service.UserSercice;

public class UserServiceImpl implements UserDetailsService, UserSercice {

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		
		
		return null;
	}

}
