package com.dh.core.security;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dh.core.dao.UserDao;

public class UserDetailsServiceImpl implements UserDetailsService {
	Map<String, LoginUser> list;

	@Resource
	private UserDao userDao;
	
	public UserDetailsServiceImpl(){
		//list = userDao.init();
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		return list.get(username);
	}
}
