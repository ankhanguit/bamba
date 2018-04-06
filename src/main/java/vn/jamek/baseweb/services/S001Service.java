package vn.jamek.baseweb.services;

import java.util.List;

import vn.jamek.baseweb.domain.User;

public interface S001Service {
	
	/**
	 * login process
	 * @param username
	 * @param password
	 * @return
	 */
	public List<User> login(String username, String password);	
}
