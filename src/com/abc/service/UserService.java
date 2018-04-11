package com.abc.service;

import java.util.List;

import com.abc.po.User;

public interface UserService {

	/**
	 * ��ȡ�û��б�
	 * @param pageNo ��1��ʼ
	 * */
	public List<User> getUserList(int pageNo,int pageSize,User user) throws Exception;
	
	/**����û�*/
	public User addUser(String loginName,String pwd,String userName) throws Exception;
	
	/**
	 * ɾ���û�
	 * @return �ɹ����ر�ɾ���û���id,-1ɾ��ʧ��
	 * */
	public int deleteUser(int id) throws Exception;
	
	/**
	 * �����û�
	 * @return �ɹ����ر������û�,null����ʧ��
	 * */
	public User updateUser(User user) throws Exception;
	
	/**
	 * ��¼
	 * @return �ɹ�����user����ʧ�ܷ���null
	 * */
	public User login(String loginName,String pwd) throws Exception;
	
}
