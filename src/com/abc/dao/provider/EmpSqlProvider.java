package com.abc.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.abc.conts.DbConts;
import com.abc.dao.mapper.EmpMapper;
import com.abc.po.Emp;
import com.abc.util.StringUtil;

public class EmpSqlProvider {

	public String getEmpList(Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT(EmpMapper.QUERY_COLUMN);
				FROM(DbConts.TABLE_EMP);
				if(params.get("name") != null) WHERE(" name LIKE CONCAT('%', #{name},'%')");
				if(params.get("deptId") != null) WHERE(" dept_id = #{deptId}");
				if(params.get("jobId") != null) WHERE(" job_id = #{jobId}");
				if(params.get("userId") != null) WHERE(" user_id = #{userId}");
			}
		}.toString();
		sql += " LIMIT #{start},#{pageSize}";		
		return sql;
	}
	
	public String updateEmp(Map<String,Object> params){
		return new SQL(){
			{
				UPDATE(DbConts.TABLE_EMP);
				Emp emp = (Emp) params.get("emp");
				if(emp != null){
					if(!StringUtil.isEmpty(emp.getName())) SET(" name = #{emp.name}");
					if(emp.getDept() != null) SET(" dept_id = #{emp.dept.id}");
					if(emp.getJob() != null) SET(" job_id = #{emp.job.id}");
					if(emp.getUser() != null) SET(" user_id = #{emp.user.id}");
					if(!StringUtil.isEmpty(emp.getPhone())) SET(" phone = #{emp.phone}");
					if(!StringUtil.isEmpty(emp.getAddr())) SET(" addr = #{emp.addr}");
					if(!StringUtil.isEmpty(emp.getEmail())) SET(" email = #{emp.email}");
					if(emp.getSex() != null) SET(" sex = #{emp.sex}");
					if(emp.getSalary() != null) SET(" salary = #{emp.salary}");
					if(emp.getBirthday() != null) SET(" birthday = #{emp.birthday}");
				}
				WHERE(" id = #{emp.id}");
			}
		}.toString();
	}
	
}
