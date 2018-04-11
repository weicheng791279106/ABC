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

	/**��ѯ�ֶ�*/
	public final static String QUERY_COLUMN = "id,login_name loginName,password,status,createdate,user_name userName";
	
	/**����������ѯ�û��б�*/
	@SelectProvider(type=UserSqlProvider.class,method="getUserList")
	List<User> getUserList(@Param("start") int start,@Param("pageSize")  int pageSize,@Param("user") User user) throws Exception;
	
	/**����Id��ѯ�û�*/
	@Select("SELECT " + QUERY_COLUMN + " FROM " + DbConts.TABLE_USER + " WHERE id = #{id}")
	User getUserById(int id) throws Exception;
	
	/**����û�*/
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("INSERT INTO " + DbConts.TABLE_USER + "(login_name,password,user_name,status,createdate) VALUE(#{loginName},#{password},#{userName},#{status},#{createDate})")
	void addUser(User user) throws Exception;
    
    /**
     * ɾ���û�
     * @return ���ر�Ӱ�����������ɾ��ʧ�ܷ���0
     * */
    @Delete("DELETE FROM " + DbConts.TABLE_USER + " WHERE id=#{id}")
    Integer deleteUser(int id) throws Exception;
    
    
    /**�����û�*/
    @SelectProvider(type=UserSqlProvider.class,method="updateUser")
    void updateUser(User user) throws Exception;
	
}
