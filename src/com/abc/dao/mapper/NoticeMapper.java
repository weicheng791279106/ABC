package com.abc.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.abc.conts.DbConts;
import com.abc.po.Notice;
import com.abc.po.UserNoticeQueryVo;

@Repository
public interface NoticeMapper {

	public static final String QUERY_COLUMN = "id,title,content,createdate createDate,user_id userId";
	
	/**根据Id查询公告*/
	@Select("SELECT " + QUERY_COLUMN + " FROM " + DbConts.TABLE_NOTICE + " WHERE id = #{id}")
	@Results({
		@Result(property="user",column="userId",one = @One(select = "com.abc.dao.mapper.UserMapper.getUserById"))
	})
	public Notice getNoticeById(Integer id) throws Exception;

	
	/**根据用户Id查找公告*/
	@Select("SELECT " + QUERY_COLUMN + " FROM " + DbConts.TABLE_NOTICE + " WHERE user_id = #{userId}" )
	public List<Notice> getNoticeListByUserId(Integer userId) throws Exception;
	
	
	/**查找用户所发布的所有公告*/
	@Select("SELECT " + UserMapper.QUERY_COLUMN + " FROM " + DbConts.TABLE_USER + " WHERE id = #{userId}" )
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="noticeList",column="id",many = @Many(select = "getNoticeListByUserId"))
	})
	public UserNoticeQueryVo getUserNoticeList(Integer userId) throws Exception;
	
	
	/**查询所有用户及其发布的公告*/
	@Select("SELECT t_user.id,login_name loginName,password,status,t_user.createdate,user_name userName FROM " 
			+ DbConts.TABLE_USER + " t_user," + DbConts.TABLE_NOTICE + " t_notice WHERE t_user.id = t_notice.user_id" 
			+ " GROUP BY t_user.id")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="noticeList",column="id",many = @Many(select = "getNoticeListByUserId"))
	})
	public List<UserNoticeQueryVo> getAllUserNoticeList() throws Exception;
	
}



