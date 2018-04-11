package com.abc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dao.mapper.UserMapper;
import com.abc.po.User;
import com.abc.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getUserList(int pageNo, int pageSize, User user) throws Exception {
		return userMapper.getUserList((pageNo-1)*pageSize,pageSize,user);
	}

	@Override
	public User addUser(String loginName,String pwd,String userName) throws Exception{
		User user = new User();
		user.setLoginName(loginName);
		user.setPassword(pwd);
		user.setUserName(userName);
		user.setCreateDate(new Date());
		user.setStatus(1);
		userMapper.addUser(user);
		return user;
	}

	@Override
	public int deleteUser(int id) throws Exception {
		Integer response = userMapper.deleteUser(id);
		return response != null && response > 0 ? id:-1;
	}

	@Override
	public User updateUser(User user) throws Exception {
		userMapper.updateUser(user);
		user = userMapper.getUserById(user.getId());
		return user;
	}

	@Override
	public User login(String loginName, String pwd) throws Exception {
		User user = new User();
		user.setLoginName(loginName);
		user.setStatus(1);
		List<User> userList = getUserList(1, 1, user);
		if(userList != null && userList.size() > 0){
			user = userList.get(0);
			if(user.getPassword().equals(pwd)) return user;
		}
		return null;
	}

}




