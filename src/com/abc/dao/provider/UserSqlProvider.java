package com.abc.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.abc.conts.DbConts;
import com.abc.dao.mapper.UserMapper;
import com.abc.po.User;
import com.abc.util.StringUtil;

/**UserMapper动态sql生成*/
public class UserSqlProvider {

	/**生成更新用户sql */
	public String updateUser(User user){
		return new SQL(){
			{
				UPDATE(DbConts.TABLE_USER);
				if(!StringUtil.isEmpty(user.getUserName())) SET(" user_name = #{userName}");
				if(!StringUtil.isEmpty(user.getLoginName())) SET(" login_name = #{loginName}");
				if(!StringUtil.isEmpty(user.getPassword())) SET(" password = #{password}");
				if(user.getStatus() != null) SET(" status = #{status}");
				WHERE(" id = #{id}");
			}
		}.toString();
	}
	
	/**根据条件查询用户*/
	public String getUserList(Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT(UserMapper.QUERY_COLUMN);
				FROM(DbConts.TABLE_USER);
				User user = (User) params.get("user");
				if(user != null){
					if(user.getId() != null) WHERE(" id = #{user.id}");
					if(user.getStatus() != null) WHERE(" status = #{user.status}");
					if(!StringUtil.isEmpty(user.getLoginName())) WHERE(" login_name LIKE CONCAT ('%',#{user.loginName},'%') ");
					if(!StringUtil.isEmpty(user.getUserName())) WHERE(" user_name LIKE CONCAT ('%',#{user.userName},'%') ");
				}
			}
		}.toString();
		sql += " LIMIT #{start},#{pageSize}";
		return sql;
	}
	
	
}



