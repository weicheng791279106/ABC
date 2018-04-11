package com.abc.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.abc.conts.DbConts;
import com.abc.po.Dept;
import com.abc.util.StringUtil;

/**DeptMapper¶¯Ì¬sqlÉú³É*/
public class DeptSqlProvider {

	public String getDeptList(Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(DbConts.TABLE_DEPT);
				Dept dept = (Dept) params.get("dept");
				if(dept != null){
					if(dept.getId() != null) WHERE(" id = #{dept.id}");
					if(!StringUtil.isEmpty(dept.getName())) WHERE(" name LIKE CONCAT('%',#{dept.name},'%')");
				}
			}
		}.toString();
		sql += " LIMIT #{start},#{pageSize}";		
		return sql;
	}
	
	public String updateDept(Map<String,Object> params){
		return new SQL(){
			{
				UPDATE(DbConts.TABLE_DEPT);
				Dept dept = (Dept) params.get("dept");
				if(dept != null){
					if(!StringUtil.isEmpty(dept.getName())) SET(" name = #{dept.name}");
					if(!StringUtil.isEmpty(dept.getRemark())) SET(" remark = #{dept.remark}");
					WHERE(" id = #{dept.id}");
				}
			}
		}.toString();
	}
	
}
