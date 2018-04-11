package com.abc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dao.mapper.NoticeMapper;
import com.abc.po.Notice;
import com.abc.po.UserNoticeQueryVo;
import com.abc.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public Notice getNoticeById(Integer id) throws Exception {
		return noticeMapper.getNoticeById(id);
	}

	@Override
	public UserNoticeQueryVo getUserNoticeList(Integer userId) throws Exception {
		return noticeMapper.getUserNoticeList(userId);
	}

	@Override
	public List<UserNoticeQueryVo> getAllUserNoticeList() throws Exception {
		return noticeMapper.getAllUserNoticeList();
	}

}
