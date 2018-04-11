package com.abc.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.abc.conts.DbConts;
import com.abc.dao.provider.UserSqlProvider;
import com.abc.po.User;

@Repository
public interface UserMapper {

	/**查询字段*/
	public final static String QUERY_COLUMN = "id,login_name loginName,password,status,createdate,user_name userName";
	
	/**根据条件查询用户列表*/
	@SelectProvider(type=UserSqlProvider.class,method="getUserList")
	List<User> getUserList(@Param("start") int start,@Param("pageSize")  int pageSize,@Param("user") User user) throws Exception;
	
	/**根据Id查询用户*/
	@Select("SELECT " + QUERY_COLUMN + " FROM " + DbConts.TABLE_USER + " WHERE id = #{id}")
	User getUserById(int id) throws Exception;
	
	/**添加用户*/
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("INSERT INTO " + DbConts.TABLE_USER + "(login_name,password,user_name,status,createdate) VALUE(#{loginName},#{password},#{userName},#{status},#{createDate})")
	void addUser(User user) throws Exception;
    
    /**
     * 删除用户
     * @return 返回被影响的行数，即删除失败返回0
     * */
    @Delete("DELETE FROM " + DbConts.TABLE_USER + " WHERE id=#{id}")
    Integer deleteUser(int id) throws Exception;
    
    
    /**更新用户*/
    @SelectProvider(type=UserSqlProvider.class,method="updateUser")
    void updateUser(User user) throws Exception;
	
}
