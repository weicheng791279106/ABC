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
import com.abc.dao.provider.DeptSqlProvider;
import com.abc.po.Dept;

@Repository
public interface DeptMapper {

	/**����Id��ѯ*/
	@Select("SELECT * FROM " + DbConts.TABLE_DEPT + " WHERE id = #{id}")
	Dept getDeptById(int id) throws Exception;
	
	/**����������ѯ�����б�*/
	@SelectProvider(type=DeptSqlProvider.class,method="getDeptList")
	List<Dept> getDeptList(@Param("start") int start,@Param("pageSize") int pageSize,@Param("dept") Dept dept) throws Exception;
	
	/**��Ӳ���*/
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	@Insert("INSERT INTO " + DbConts.TABLE_DEPT + "(name,remark) VALUE (#{name},#{remark})")
	void addDept(Dept dept) throws Exception;
	
	/**
	 * ɾ������
	 * @return ���ر�Ӱ�����������ɾ��ʧ�ܷ���0
	 * */
	@Delete("DELETE FROM " + DbConts.TABLE_DEPT + " WHERE id = #{id}")
	Integer deleteDept(int id) throws Exception;
	
	/**���²���*/
	@SelectProvider(type=DeptSqlProvider.class,method="updateDept")
	void updateDept(@Param("dept") Dept dept) throws Exception;
	
}
