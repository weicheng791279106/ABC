package com.abc.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.abc.conts.DbConts;
import com.abc.po.Job;
import com.abc.util.StringUtil;

/**JobMapper¶¯Ì¬sqlÉú³É*/
public class JobSqlProvider {

	public String getJobList(Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(DbConts.TABLE_JOB);
				Job job = (Job) params.get("job");
				if(job != null){
					if(job.getId() != null) WHERE(" id = #{job.id}");
					if(!StringUtil.isEmpty(job.getName())) WHERE(" name LIKE CONCAT('%',#{job.name},'%')");
				}
			}
		}.toString();
		sql += " LIMIT #{start},#{pageSize}";		
		return sql;
	}
	
	public String updateJob(Map<String,Object> params){
		return new SQL(){
			{
				UPDATE(DbConts.TABLE_JOB);
				Job job = (Job) params.get("job");
				if(job != null){
					if(!StringUtil.isEmpty(job.getName())) SET(" name = #{job.name}");
					if(!StringUtil.isEmpty(job.getRemark())) SET(" remark = #{job.remark}");
					WHERE(" id = #{job.id}");
				}
			}
		}.toString();
	}
	
}
