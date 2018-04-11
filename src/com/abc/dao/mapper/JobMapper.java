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
import com.abc.dao.provider.JobSqlProvider;
import com.abc.po.Job;

@Repository
public interface JobMapper {

	/**根据Id查询*/
	@Select("SELECT * FROM " + DbConts.TABLE_JOB + " WHERE id = #{id}")
	Job getJobById(int id) throws Exception;
	
	/**根据条件查询岗位列表*/
	@SelectProvider(type=JobSqlProvider.class,method="getJobList")
	List<Job> getJobList(@Param("start") int start,@Param("pageSize") int pageSize,@Param("job") Job job) throws Exception;
	
	/**添加岗位*/
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	@Insert("INSERT INTO " + DbConts.TABLE_JOB + " (name,remark) VALUE (#{name},#{remark})") 
	void addJob(Job job) throws Exception;
	
	/**
	 * 删除岗位
	 * @return 返回被影响的行数，即删除失败返回0
	 * */
	@Delete("DELETE FROM " + DbConts.TABLE_JOB + " WHERE id = #{id}")
	Integer deleteJob(int id) throws Exception;
	
	/**更新岗位*/
	@SelectProvider(type=JobSqlProvider.class,method="updateJob")
	void updateJob(@Param("job") Job dept) throws Exception;
	
}
