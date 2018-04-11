package com.abc.po;

import java.util.List;

/**查询用户信息及其发布的所有公告*/
public class UserNoticeQueryVo extends User{

	private List<Notice> noticeList;

	public List<Notice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}
	
}
