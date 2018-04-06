package vn.jamek.baseweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.jamek.baseweb.domain.User;
import vn.jamek.baseweb.persistence.UserMapper;
import vn.jamek.baseweb.services.S001Service;

@Service
public class S001ServiceImpl implements S001Service{
	
	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> login(String username, String password) {
		
		// TODO Auto-generated method stub
		return userMapper.login(username, password);
	}

}
