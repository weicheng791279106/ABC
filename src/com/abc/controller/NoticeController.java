package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.conts.RespCode;
import com.abc.po.Notice;
import com.abc.po.RespBase;
import com.abc.po.UserNoticeQueryVo;
import com.abc.service.NoticeService;

@RequestMapping("notice/")
@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("getNoticeById")
	@ResponseBody
	public RespBase getNoticeById(Integer id) throws Exception{
		Notice notice = noticeService.getNoticeById(id);
		return new RespBase(notice == null ? RespCode.FAIL:RespCode.SUCCESS).setData(notice);
	}
	
	@RequestMapping("getUserNoticeList")
	@ResponseBody
	public RespBase getUserNoticeList(Integer id) throws Exception{
		UserNoticeQueryVo userNoticeQueryVo = noticeService.getUserNoticeList(id);
		return new RespBase(RespCode.SUCCESS).setData(userNoticeQueryVo);
	}
	
	@RequestMapping("getAllUserNoticeList")
	@ResponseBody
	public RespBase getAllUserNoticeList() throws Exception{
		List<UserNoticeQueryVo> userNoticeQueryVoList = noticeService.getAllUserNoticeList();
		return new RespBase(RespCode.SUCCESS).setData(userNoticeQueryVoList);
	}

}
