package com.abc.service;

import java.util.List;

import com.abc.po.Notice;
import com.abc.po.UserNoticeQueryVo;

public interface NoticeService {

	/**����Id��ȡ����*/
	public Notice getNoticeById(Integer id) throws Exception;
	
	/**�����û����ҹ���*/
	public UserNoticeQueryVo getUserNoticeList(Integer userId) throws Exception;
	
	/**��ѯ�����û����䷢���Ĺ���*/
	public List<UserNoticeQueryVo> getAllUserNoticeList() throws Exception;
	
}
