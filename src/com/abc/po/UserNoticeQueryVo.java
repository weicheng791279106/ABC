package com.abc.po;

import java.util.List;

/**��ѯ�û���Ϣ���䷢�������й���*/
public class UserNoticeQueryVo extends User{

	private List<Notice> noticeList;

	public List<Notice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}
	
}
