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

	/**����Id��ѯ*/
	@Select("SELECT * FROM " + DbConts.TABLE_JOB + " WHERE id = #{id}")
	Job getJobById(int id) throws Exception;
	
	/**����������ѯ��λ�б�*/
	@SelectProvider(type=JobSqlProvider.class,method="getJobList")
	List<Job> getJobList(@Param("start") int start,@Param("pageSize") int pageSize,@Param("job") Job job) throws Exception;
	
	/**��Ӹ�λ*/
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	@Insert("INSERT INTO " + DbConts.TABLE_JOB + " (name,remark) VALUE (#{name},#{remark})") 
	void addJob(Job job) throws Exception;
	
	/**
	 * ɾ����λ
	 * @return ���ر�Ӱ�����������ɾ��ʧ�ܷ���0
	 * */
	@Delete("DELETE FROM " + DbConts.TABLE_JOB + " WHERE id = #{id}")
	Integer deleteJob(int id) throws Exception;
	
	/**���¸�λ*/
	@SelectProvider(type=JobSqlProvider.class,method="updateJob")
	void updateJob(@Param("job") Job dept) throws Exception;
	
}
