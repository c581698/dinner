package com.dh.core.dao;

import java.util.List;

import com.dh.core.security.LoginUser;

public interface UserDao {
	public LoginUser login(String username,String password);

	public List<LoginUser> init();
}
