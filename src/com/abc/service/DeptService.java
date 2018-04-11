package com.abc.service;

import java.util.List;

import com.abc.po.Dept;

public interface DeptService {

	/**根据Id查找部门*/
	public Dept getDeptById(int id) throws Exception;
	
	/**根据条件查找部门*/
	public List<Dept> getDeptList(int pageNo,int pageSize,Dept dept) throws Exception;
	
	/**
	 * 删除部门
	 * @return 成功返回被删除部门的id,-1删除失败
	 * */
	public int deleteDept(int id) throws Exception;
	
	/**添加部门*/
	public Dept addDept(String name,String remark) throws Exception;
	
	/**
	 * 更新部门
	 * @return 成功返回被更新部门,null更新失败
	 * */
	public Dept updateDept(Dept dept) throws Exception;
	
}
