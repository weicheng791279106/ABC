package com.abc.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.conts.RespCode;
import com.abc.conts.SessionConts;
import com.abc.po.RespBase;
import com.abc.po.User;
import com.abc.service.UserService;

/**
 * �û�ģ��Controller
 * */

@Controller
@RequestMapping("user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * ��ȡ�û��б�
	 * @param pageNo ��1��ʼ
	 * */
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET,value="getUserList")
	public RespBase getUserList(int pageNo,int pageSize,Integer id,Integer status,String loginName,String userName) throws Exception{
		User user = new User();
		if(id != null) user.setId(id);
		if(status != null) user.setStatus(status);
		user.setLoginName(loginName);
		user.setUserName(userName);
		return new RespBase(RespCode.SUCCESS).setData(userService.getUserList(pageNo, pageSize, user));
	}
	
	/**����û�*/
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="addUser")
	public RespBase addUser(String loginName,String pwd,String userName) throws Exception{
		return new RespBase(RespCode.SUCCESS).setData(userService.addUser(loginName,pwd,userName));
	}
	
	/**ɾ���û�*/
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET,value="deleteUser")
	public RespBase deleteUser(Integer id) throws Exception{
		if(id == null) return new RespBase(RespCode.FAIL).setMsg("û�д���Id");
		int result = userService.deleteUser(id);
		return new RespBase(result == -1 ? RespCode.FAIL:RespCode.SUCCESS).setData(result);
	}
	
	/**�����û�*/
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="updateUser")
	public RespBase updateUser(User user) throws Exception{
		if(user.getId() == null) return new RespBase(RespCode.FAIL).setMsg("û�д���Id");
		user = userService.updateUser(user);
		return new RespBase(user == null ? RespCode.FAIL:RespCode.SUCCESS).setData(user);
	}
	
	/**��¼*/
	@RequestMapping("login")
	@ResponseBody
	public RespBase login(HttpSession httpSession,String loginName,String pwd) throws Exception {
		User user = userService.login(loginName, pwd);
		if(user != null) httpSession.setAttribute(SessionConts.USERNAME, user.getUserName()); /*��session�б����û���Ϣ*/
		else throw new Exception("�û������������");
		return new RespBase(user == null ? RespCode.FAIL:RespCode.SUCCESS).setData(user).setMsg(user == null ? "��¼ʧ��":"��¼�ɹ�");
	}
	
	/**�˳���¼*/
	@RequestMapping("logout")
	@ResponseBody
	public RespBase logout(HttpSession httpSession) throws Exception {
		httpSession.invalidate();
		return new RespBase(RespCode.SUCCESS).setMsg("�˳���¼�ɹ�");
	}
	
	
	

}
