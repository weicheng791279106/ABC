package com.abc.service;

import java.util.List;

import com.abc.po.Notice;
import com.abc.po.UserNoticeQueryVo;

public interface NoticeService {

	/**根据Id获取公告*/
	public Notice getNoticeById(Integer id) throws Exception;
	
	/**根据用户查找公告*/
	public UserNoticeQueryVo getUserNoticeList(Integer userId) throws Exception;
	
	/**查询所有用户及其发布的公告*/
	public List<UserNoticeQueryVo> getAllUserNoticeList() throws Exception;
	
}
