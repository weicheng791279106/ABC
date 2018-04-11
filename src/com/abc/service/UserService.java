package com.abc.service;

import java.util.List;

import com.abc.po.User;

public interface UserService {

	/**
	 * 获取用户列表
	 * @param pageNo 从1开始
	 * */
	public List<User> getUserList(int pageNo,int pageSize,User user) throws Exception;
	
	/**添加用户*/
	public User addUser(String loginName,String pwd,String userName) throws Exception;
	
	/**
	 * 删除用户
	 * @return 成功返回被删除用户的id,-1删除失败
	 * */
	public int deleteUser(int id) throws Exception;
	
	/**
	 * 更新用户
	 * @return 成功返回被更新用户,null更新失败
	 * */
	public User updateUser(User user) throws Exception;
	
	/**
	 * 登录
	 * @return 成功返回user对象，失败返回null
	 * */
	public User login(String loginName,String pwd) throws Exception;
	
}
