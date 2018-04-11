package com.abc.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.abc.conts.DbConts;
import com.abc.dao.provider.EmpSqlProvider;
import com.abc.dao.provider.JobSqlProvider;
import com.abc.po.Emp;
import com.abc.po.Job;

@Repository
public interface EmpMapper {

	/**��ѯ�ֶ�*/
	public final static String QUERY_COLUMN = "id,name,dept_id,job_id,user_id,salary,phone,addr,email,sex,birthday,createdate createDate";
	
	/**��ѯԱ��*/
	@Select("SELECT "+ QUERY_COLUMN + " FROM " + DbConts.TABLE_EMP + " WHERE id = #{id}")
	@Results({
		@Result(property="user",column="user_id",one = @One(select = "com.abc.dao.mapper.UserMapper.getUserById")),
		@Result(property="job",column="job_id",one = @One(select = "com.abc.dao.mapper.JobMapper.getJobById")),
		@Result(property="dept",column="dept_id",one = @One(select = "com.abc.dao.mapper.DeptMapper.getDeptById"))
	})
	public Emp getEmpById(int id) throws Exception;
	
	/**������������Ա��*/
	@SelectProvider(type=EmpSqlProvider.class,method="getEmpList")
	@Results({
		@Result(property="user",column="user_id",one = @One(select = "com.abc.dao.mapper.UserMapper.getUserById")),
		@Result(property="job",column="job_id",one = @One(select = "com.abc.dao.mapper.JobMapper.getJobById")),
		@Result(property="dept",column="dept_id",one = @One(select = "com.abc.dao.mapper.DeptMapper.getDeptById"))
	})
	public List<Emp> getEmpList(@Param("start") Integer start,@Param("pageSize") Integer pageNo,
			@Param("name") String name,@Param("deptId") Integer deptId,@Param("jobId") Integer jobId,@Param("userId") Integer userId) throws Exception;
	
	/**
	 * ɾ��Ա��
	 * @return ���ر�Ӱ�����������ɾ��ʧ�ܷ���0
	 * */
	@Delete("DELETE FROM " + DbConts.TABLE_EMP + " WHERE id = #{id}")
	public Integer deleteEmp(int id) throws Exception;
	
	/**���Ա��*/
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	@Insert("INSERT INTO " + DbConts.TABLE_EMP + " (name,dept_id,job_id,user_id,salary,phone,addr,email,sex,birthday,createdate) VALUE "
			+ "(#{name},#{dept.id},#{job.id},#{user.id},#{salary},#{phone},#{addr},#{email},#{sex},#{birthday},#{createDate})") 
	void addEmp(Emp emp) throws Exception;
	
	/**����Ա��*/
	@SelectProvider(type=EmpSqlProvider.class,method="updateEmp")
	void updateEmp(@Param("emp") Emp emp) throws Exception;
	
	
}
